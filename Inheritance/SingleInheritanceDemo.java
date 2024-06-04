package Inheritance;

public class SingleInheritanceDemo {

    public static void main(String[] args) {
        System.out.println("Car");
        Car cr = new Car("Blue", "12");
        cr.displayInfo();
        cr.start();
        System.out.println("Car Speed: " + cr.getSpeed());
        cr.accelerate();
        System.out.println("After Accelerate Method");
        System.out.println("Car Speed: " + cr.getSpeed());
        cr.stop();

        System.out.println("\nFlying Car");
        FlyingCar fc = new FlyingCar("Green", "16");
        fc.displayInfo();
        fc.start();
        System.out.println("Flying Car Speed: " + fc.getSpeed());
        System.out.println("Flying Car Height: " + fc.getHeight());
        fc.accelerate();
        System.out.println("After Accelerate Method");
        System.out.println("Flying Car Speed: " + fc.getSpeed());
        fc.ascend();
        System.out.println("After Ascend Method");
        System.out.println("Flying Car Height: " + fc.getHeight());
        fc.descend();
        System.out.println("After Descend Method");
        System.out.println("Flying Car Height: " + fc.getHeight());
        fc.stop();
        System.out.println("Flying Car Speed: " + fc.getSpeed());
    }
}
