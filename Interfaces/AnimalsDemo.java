package Interfaces;

public class AnimalsDemo {

    public static void main(String[] args) {
        IAnimal animal;
        System.out.println("Lion");
        animal = new Lion();
        animal.eats();
        animal.walks();
        System.out.println("\nElephant");
        animal = new Elephant();
        animal.eats();
        animal.walks();
        System.out.println("\nOstrich");
        animal = new Ostrich();
        animal.eats();
        animal.walks();
    }
}
