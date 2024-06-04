package Inheritance;

public class Car {

    protected String engineModal;
    protected String modelName;
    private double speed;
    private String engineStatus;

    public Car() {
        setEngineModal("");
        setModelName("1");
        setSpeed(0.0);
        setEngineStatus("");
    }

    public Car(String modelName, String engineModal) {
        this();
        setModelName(modelName);
        setEngineModal(engineModal);
    }

    public void start() {
        setEngineStatus("Start Mode");
        System.out.println("Engine is ON");
    }

    public void startStop(String s) {
        if (s.equalsIgnoreCase("start")) {
            this.start();
        } else if (s.equalsIgnoreCase("stop")) {
            this.stop();
        }
    }

    public void accelerate() {
        setSpeed(speed + 3);
    }

    public void deAccelerate() {
        setSpeed(speed - 2);
    }

    public void stop() {
        setSpeed(0);
        setEngineStatus("stop Mode");
    }

    public void applyBrake() {
        setSpeed(0);
    }

    public void displayInfo() {
        System.out.println("Model: " + modelName);
        System.out.println("Engine Modal: " + engineModal);
    }

    public final void setEngineModal(String engineModal) {
        this.engineModal = engineModal;
    }

    public final void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getSpeed() {
        return (int) speed;
    }

    protected final void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getEngineStatus() {
        return engineStatus;
    }

    public final void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }
}
