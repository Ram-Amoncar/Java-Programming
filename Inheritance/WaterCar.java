package Inheritance;

public class WaterCar extends Car {

    private double floatingSpeed;

    public WaterCar() {
        super();
        setFloatingSpeed(0.0);
    }

    public WaterCar(String modelName, String engineModal) {
        super(modelName, engineModal);
        setFloatingSpeed(0.0);
    }

    @Override
    public void accelerate() {
        setFloatingSpeed(getFloatingSpeed() + 2);
    }

    @Override
    public void deAccelerate() {
        setFloatingSpeed(getFloatingSpeed() - 2);
    }

    public void swim() {
        System.out.println("Swimming");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Floating speed: " + getFloatingSpeed());
    }

    private void setFloatingSpeed(double floatingSpeed) {
        this.floatingSpeed = floatingSpeed;
    }

    public double getFloatingSpeed() {
        return floatingSpeed;
    }
}
