package Inheritance;

public class SpaceCar extends FlyingCar {

    private double airPressure;

    public SpaceCar() {
        super();
        setAirPressure(0.0);
    }

    public SpaceCar(String modelName, String engineModal) {
        super(modelName, engineModal);
        setAirPressure(0.0);
    }

    @Override
    public void accelerate() {
        setSpeed(getSpeed() + 100);
    }

    @Override
    public void deAccelerate() {
        setSpeed(getSpeed() - 50);
    }

    public void checkPressure() {
        System.out.println("Checking pressure");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Air Pressure: " + getAirPressure());
    }

    public double getAirPressure() {
        return airPressure;
    }

    private void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
    }
}
