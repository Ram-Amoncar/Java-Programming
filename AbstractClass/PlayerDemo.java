package AbstractClass;

public class PlayerDemo {

    public static void main(String[] args) {
        // Declaring as parent class object
        Player player;

        // Runtime Polymorphism
        player = new CricketPlayer("Virat Kohli");
        player.plays();

        player = new FootballPlayer("Lionel Messi");
        player.plays();

        player = new HockeyPlayer("Dhanraj Pillay");
        player.plays();
    }
}
