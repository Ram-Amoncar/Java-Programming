package Interfaces;

public class Elephant implements IAnimal {

    @Override
    public void eats() {
        System.out.println("Elephant eats plants");
    }

    @Override
    public void walks() {
        System.out.println("Elephant walks on 4 legs");
    }
}
