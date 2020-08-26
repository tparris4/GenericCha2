package learn.learningacademy;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>> {
    //the t will be replaced automatically by java in order to put the appropiate class to the paramater
    //this is a parametized type
    //T is a bounded type, have to limit it to Player classes
    //use extends to access method in PLayer
    //can use interfaces with multiple bounds by using the interfaces after
    //i.e. extends Player & Manager
    //base class
    private String name;
    //int player = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    //    List<SoccerPlayer>
//    List<FootballPlayer>
    //no relationship between these two
    //common parent (Lists)
    int played = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + "is already on the team");
            //cast it to a Player type
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + "picked for team " + this.name);
            //this.name being the team name
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message;

        if (ourScore > theirScore) {
            won++;
            message = "beat";
        } else if (ourScore == theirScore) {
            tied++;
            message = "drew with";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
            //call matchResult again, pass null so it doesn't get executed again
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;

        }
        return 0;
    }

}