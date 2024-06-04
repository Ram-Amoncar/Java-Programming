package Helicopter;

public final class TailRotor {

    private int tailRPM;
    private String tailRotorStatus;

    public TailRotor() {
        setTailRPM(0);
        setTailRotorStatus("off");
    }

    public String getTailRotorStatus() {
        return tailRotorStatus;
    }

    public void setTailRotorStatus(String tailRotorStatus) {
        this.tailRotorStatus = tailRotorStatus;
    }

    public int getTailRPM() {
        return tailRPM;
    }

    public void setTailRPM(int tailRPM) {
        this.tailRPM = tailRPM;
    }

}
