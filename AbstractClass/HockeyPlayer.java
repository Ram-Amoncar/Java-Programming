package AbstractClass;

public class HockeyPlayer extends Player {

    public HockeyPlayer(String name) {
        super(name);
    }

    @Override
    public void plays() {
        System.out.println(getName() + " plays Hockey");
    }
}
