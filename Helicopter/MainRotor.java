package Helicopter;

public final class MainRotor {

    private int mainRPM;
    private int bladeLength;

    public void setMainRPM(int mainRPM) {
        this.mainRPM = mainRPM;
    }

    public void setBladeLength(int bladeLength) {
        this.bladeLength = bladeLength;
    }

    public void setRotorStatus(String rotorStatus) {
        this.rotorStatus = rotorStatus;
    }

    private String rotorStatus;

    public MainRotor() {
        mainRPM = 0;
        bladeLength = 8;
        rotorStatus = "off";

    }

    public String getRotorStatus() {
        return rotorStatus;
    }

    public int getBladeLength() {
        return bladeLength;
    }

    public int getMainRPM() {
        return mainRPM;
    }

}
