package AbstractClass;

public class CricketPlayer extends Player {

    public CricketPlayer(String name) {
        super(name);
    }

    @Override
    public void plays() {
        System.out.println(getName() + " plays Cricket");
    }
}
