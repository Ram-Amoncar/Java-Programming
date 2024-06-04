package Inheritance;

public class MultiLevelInheritanceDemo {

    public static void main(String[] args) {
        // MultiLevel inheritance
        System.out.println("Normal Car");
        Car c = new Car("AV189", "QWT189");
        c.displayInfo();
        System.out.println("\nFlying Car");
        FlyingCar fc = new FlyingCar("FC500", "ERE1");
        fc.displayInfo();
        System.out.println("\nSpace Car");
        SpaceCar sc = new SpaceCar("SC180", "670TW");
        sc.checkPressure();
        sc.accelerate();
        System.out.println("Space Car speed: " + sc.getSpeed());
        sc.deAccelerate();
        sc.displayInfo();
    }
}
