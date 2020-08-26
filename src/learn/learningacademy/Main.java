package learn.learningacademy;

public class Main {

    public static void main(String[] args) {
	// write your code here

        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        Team<FootballPlayer> baseballTeam = new Team<>("Chicago cubs");


        Team<Player> brokenTeam = new Team<>("This won't work");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn= new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle= new Team<>("Fremantle");


        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(baseballTeam, 3, 8);

        baseballTeam.matchResult(fremantle, 2, 1);

        footballLeague.add(melbourne);
        footballLeague.add(baseballTeam);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);

        //footballLeague.add(brokenTeam);
        //cannot add because we did not make a brokenteam parametized type

    }
}
