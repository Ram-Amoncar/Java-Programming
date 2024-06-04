package TV;

// Package private class
final class InputOutput {

    // InputOutput instance variables
    private boolean power;
    private boolean hdmiSin;
    private boolean dpSin;
    private boolean usbSin;
    private boolean avSin;
    private boolean outHdmi;
    private boolean ethernet;
    public static String currentInput;

    // Non Parameterized constructor
    public InputOutput() {
        power = true;
        hdmiSin = false;
        dpSin = false;
        usbSin = false;
        avSin = false;
        outHdmi = false;
        ethernet = false;
        setCurrentInput("None");
    }

    // IR receiver
    public int receiveIrSignal() {
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                return 999;
            }
        } catch (Exception e) {
            return 999;
        }
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public void setHdmiSin(boolean hdmiSin) {
        this.hdmiSin = hdmiSin;
    }

    public void setDpSin(boolean dpSin) {
        this.dpSin = dpSin;
    }

    public void setUsbSin(boolean usbSin) {
        this.usbSin = usbSin;
    }

    public void setAvSin(boolean avSin) {
        this.avSin = avSin;
    }

    public void setOutHdmi(boolean outHdmi) {
        this.outHdmi = outHdmi;
    }

    public void setEthernet(boolean ethernet) {
        this.ethernet = ethernet;
    }

    // HDMI Signal
    public boolean isHdmiSin() {
        return hdmiSin;
    }

    // Display Port
    public boolean isDpSin() {
        return dpSin;
    }

    // USB Signal
    public boolean isUsbSin() {
        return usbSin;
    }

    // HDMI output port
    public boolean isOutHdmi() {
        return outHdmi;
    }

    // AV  Signal
    public boolean isAvSin() {
        return avSin;
    }

    // Ethernet connection
    public boolean isEthernet() {
        return ethernet;
    }

    // Current Input
    public String getCurrentInput() {
        return currentInput;
    }

    public void setCurrentInput(String currentInput) {
        InputOutput.currentInput = currentInput;
    }

    public boolean isPower() {
        return power;
    }

}
