package Interfaces;

public class Lion implements IAnimal {

    @Override
    public void eats() {
        System.out.println("Lion eats other animals");
    }

    @Override
    public void walks() {
        System.out.println("Lion walks on 4 legs");
    }
}
