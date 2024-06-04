package Interfaces;

public class Ostrich implements IAnimal {

    @Override
    public void eats() {
        System.out.println("Ostrich eats other animals and plants");
    }

    @Override
    public void walks() {
        System.out.println("Ostrich walks on 2 legs");
    }
}
