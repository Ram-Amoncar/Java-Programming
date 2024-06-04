package Helicopter;

public final class Engine {

    private String engineStatus;

    public Engine() {
        setEngineStatus("off");
    }

    public String getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(String engineStatus) {
        this.engineStatus = engineStatus;
    }

}
