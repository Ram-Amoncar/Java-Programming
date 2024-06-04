package Inheritance;

public class FlyingCar extends Car {

    private double height;

    public FlyingCar() {
        super();
        setHeight(0.0);
    }

    public FlyingCar(String model, String engineModal) {
        super(model, engineModal);
        setHeight(0.0);
    }

    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void accelerate() {
        super.setSpeed(getSpeed() + 10);
    }

    public void ascend() {
        setHeight(this.height + 2);
        System.out.println("Flying Height: " + getHeight());
    }

    public void descend() {
        if (height > 0) {
            setHeight(height - 2);
            System.out.println("Flying Height: " + getHeight());
        } else {
            System.out.println("Car is on the ground");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Flying Height: " + getHeight());
    }

    public double getHeight() {
        return this.height;
    }

    protected final void setHeight(double height) {
        this.height = height;
    }

}
