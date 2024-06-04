package AbstractClass;

public class FootballPlayer extends Player {

    public FootballPlayer(String name) {
        super(name);
    }

    @Override
    public void plays() {
        System.out.println(getName() + " plays Football");
    }

}
