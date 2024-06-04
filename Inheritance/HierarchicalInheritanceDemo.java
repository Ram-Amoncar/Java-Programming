package Inheritance;

public class HierarchicalInheritanceDemo {

    public static void main(String[] args) {
        // hierarchical and Hybrid inheritance
        System.out.println("Flying Car");
        Car fc = new FlyingCar("FC42", "ERE21");
        fc.start();
        System.out.println("Engine status: " + fc.getEngineStatus());
        fc.accelerate();
        System.out.println("FC speed: " + fc.getSpeed());
        fc.deAccelerate();
        fc.displayInfo();
        System.out.println("\nWater Car");
        Car wc = new WaterCar("WC69", "Wdc03");
        wc.start();
        System.out.println("Engine status: " + wc.getEngineStatus());
        wc.accelerate();
        System.out.println("WC speed: " + wc.getSpeed());
        wc.deAccelerate();
        wc.displayInfo();
    }
}
