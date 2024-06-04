package TV;

// Package private class
final class Motherboard {

    // Motherboard instance variable
    private String signalQuality;
    private boolean debugMode;
    private boolean timerOn;
    private long startTime;
    private long endTime;
    private double screenTemp;
    private long beginTime;
    private int min;
    private boolean wifi;
    private String network;

    public Motherboard() {
        setLastTime();
        setScreenTemp(28);
        setTimer(0);
        setWifi(false);
        setDebugMode(false);
        timerOn(false);
        setNetwork("None");
        setSignalQuality("NO SIGNAL");
    }

    // Routine tasks
    // Method that checks the screen Temperature
    public boolean isOverheating() {
        if (debugMode) {
            process("Checking screen Temperature", 100);
        }
        return screenTemp > 50;
    }

    // Method that auto turns off the screen due any exception
    public boolean autoTurnOff() {
        if (timer()) {
            timerOn(false);
            return false;
        } else if (upTime() >= 10) {
            setLastTime();
            return false;
        } else {
            return true;
        }
    }

    // Method that auto-detects Input signal
    public String autoDetectSin(boolean av, boolean hdmi, boolean dp, boolean usb) {
        String[] signals = {"AV", "HDMI", "Display Port", "USB"};
        Boolean[] sins = {av, hdmi, dp, usb};
        for (int i = 0; i < 4; i++) {
            if (sins[i]) {
                return signals[i];
            }
        }
        return "None";
    }

    // To calculate uptime of the screen
    public int upTime() {
        setEndTime();
        return (int) ((endTime - startTime) / 60000);
    }

    // Auto-Detects Network Connection
    public void autoDetectNet(boolean ethernet) {
        String[] signals = {"Ethernet", "WiFi"};
        Boolean[] sins = {ethernet, wifi};
        for (int i = 0; i < 2; i++) {
            if (sins[i]) {
                setNetwork(signals[i]);
            }
        }
        setNetwork("None");
    }

    // Time
    public String time() {
        java.time.format.DateTimeFormatter dtf
                = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dtf.format(java.time.LocalDateTime.now());
    }

    // Priority tasks
    // Method that processes Image Signal
    public boolean processImageSin() {
        if (debugMode) {
            process("Processing Image", 50);
        }
        return true;
    }

    // Method that processes Audio Signal
    public boolean processAudioSin() {
        if (debugMode) {
            process("Processing Audio", 100);
        }
        return true;
    }

    // Timer user-define
    // Timer to turn off the screen
    public boolean timer() {
        setEndTime();
        return timerOn && (endTime - beginTime) / 60000 >= min;
    }

    public void timerOn(boolean is) {
        this.timerOn = is;
    }

    public int setTimer(int min) {
        this.min = min;
        timerOn(true);
        beginTime = System.currentTimeMillis();
        return this.min;
    }

    // Signal Quality
    public String getSignalQuality() {
        return signalQuality;
    }

    // Method that checks signal quality
    public String checkSinQuality() {
        java.util.Random rand = new java.util.Random();
        return rand.nextFloat(1f, 11f) >= 9.80 ? "Good" : "Poor";
    }

    public void setSignalQuality(String signalQuality) {
        this.signalQuality = signalQuality;
    }

    // Debugger Mode
    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    // Time span is calculate where no activity takes place
    public void setLastTime() {
        startTime = System.currentTimeMillis();
        senseScreenTemp();
    }

    private void senseScreenTemp() {
        setScreenTemp(screenTemp + 0.02);
    }

    private void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    // Screen temperature
    public double getScreenTemp() {
        return screenTemp;
    }

    private void setScreenTemp(double screenTemp) {
        this.screenTemp = screenTemp;
    }

    // Wi-Fi Connectivity
    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    // Network connection
    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    // Misc
    // Load method is used load anything
    static void process(String str, int milSec) {
        int num = 0;
        java.util.Random rand = new java.util.Random();
        do {
            num = rand.nextInt(num + 1, 101);
            System.out.println(str + " ........" + num + "%");
            delay(milSec);
        } while (num != 100);
    }

    static void delay(int milSec) {
        try {
            Thread.sleep(milSec);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
