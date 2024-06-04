package TV;

// Public Class
public class Television {

    // Television instance variables
    private final Motherboard mb;
    private final InputOutput io;
    private Screen sn;
    private final Speaker spk1;
    private final Speaker spk2;
    private String model;
    private String brand;
    private int contrast;
    private int brightness;
    private int sharpness;
    private int balance;
    // Standard, Dynamic & Mild
    private String pictureMode;
    // Standard, Music, Movie, & Sports
    private String soundMode;
    private int volume;
    private int channelNo;
    private String input;
    private boolean debugMode;

    // Non Parameterized Constructor
    public Television() {
        mb = new Motherboard();
        io = new InputOutput();
        spk1 = new Speaker("Left");
        spk2 = new Speaker("Right");
        this.debugMode = false;
        setBalance(50);
        autoSetInput();
        this.brightness = 50;
        this.contrast = 50;
        this.sharpness = 50;
        this.pictureMode = "Standard";
        this.soundMode = "Standard";
        this.volume = 10;
        this.channelNo = 1;
        setConfiguration();
    }

    //Method used to Set Configuration
    private void setConfiguration() {
        System.out.println("Set Up your TV Configuration");
        outer:
        {
            while (true) {
                System.out.println("""
                        1. Standard
                        2. Customized Setup""");
                switch (io.receiveIrSignal()) {
                    case 1 -> {
                        this.model = "2022";
                        this.brand = "Generic";
                        sn = new Screen();
                        break outer;
                    }
                    case 2 -> {
                        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
                            System.out.println("Enter the brand of TV");
                            this.brand = sc.next();
                            System.out.println("BRAND SET TO: " + brand);
                            System.out.println("Enter the model of TV");
                            this.model = sc.next();
                        }
                        System.out.println("MODEL SET TO: " + model);
                        System.out.println("Select the screen quality of TV");
                        System.out.println("""
                                1. 1080p (1920*1080)
                                2. 2K    (2048*1080)
                                3. 4K    (3840*2160)""");
                        switch (io.receiveIrSignal()) {
                            case 1 ->
                                sn = new Screen(1920, 1080);
                            case 2 ->
                                sn = new Screen(2048, 1080);
                            case 3 ->
                                sn = new Screen(3840, 2160);
                            default -> {
                                System.out.println("INVALID ENTRY");
                                sn = new Screen(1920, 1080);
                            }
                        }
                        System.out.println("QUALITY SET TO: " + sn.getHorizontalPixels()
                                + "*" + sn.getVerticalPixels());
                        break outer;
                    }

                    default ->
                        System.out.println("INVALID ENTRY");

                }
            }
        }
    }

    // Show/Main/Run/Watch/Display method
    public void show() {
        if (isScreenON()) {
            // Routine tasks
            // updates activity
            mb.setLastTime();
            // checks if screen is overheating
            sn.setOn(mb.isOverheating());
            // default timer && user define timer
            sn.setOn(mb.autoTurnOff());
            // auto detects Signal + sets currentInput
            io.setCurrentInput(
                    mb.autoDetectSin(io.isAvSin(), io.isHdmiSin(), io.isDpSin(), io.isUsbSin())
            );
            // checks for Signal Quality
            mb.setSignalQuality(mb.checkSinQuality());
            // auto-detect network connection
            mb.autoDetectNet(io.isEthernet());

            // Priority tasks
            // Image
            sn.display(mb.processImageSin(), io.getCurrentInput());
            if (!Speaker.isMuted()) {
                // Audio
                spk1.outputAudio(mb.processAudioSin(), io.getCurrentInput());
                spk2.outputAudio(mb.processAudioSin(), io.getCurrentInput());
            } else {
                System.out.println("SPEAKER ARE MUTED");
            }
        }
    }

    //Method to set Timer for turning-off screen
    public void setTimer() {
        // updates activity
        mb.setLastTime();

        System.out.println("Timer has been set for " + mb.setTimer(io.receiveIrSignal()));
    }

    // Method turn-Off timer
    public void turnOffTimer() {
        // updates activity
        mb.setLastTime();
        mb.setTimer(0);
        System.out.println("TIMER TURNED OFF");
    }

    // Methods to control the screen
    // Method to turn ON or OFF screen
    public void turnOnOffScreen() {
        // updates activity
        mb.setLastTime();
        if (!sn.isOn()) {
            sn.turnOn();
            System.out.println("Screen is ON");
        } else {
            sn.turnOff();
            System.out.println("Screen is OFF");
        }
    }

    //Method to check screen is off
    private boolean isScreenON() {
        if (sn.isOn()) {
            return true;
        } else {
            System.out.println("SCREEN IS OFF");
            return false;
        }
    }

    //Method to change channel on tv
    public void changeChannel() {
        if (isScreenON()) {
            System.out.println("Current Channel: " + channelNo);
            io.setCurrentInput("TV");
            System.out.println("INPUT SET TO: " + io.getCurrentInput());
            System.out.println("Enter channel No");
            if (io.receiveIrSignal() < 999 && io.receiveIrSignal() > 0) {
                this.channelNo = io.receiveIrSignal();
            } else {
                System.out.println("CHANNEL NOT FOUND");
            }
            System.out.println("Channel No: " + this.channelNo);
        }
    }

    // Debugging Mode
    public void on_Off_DebugMode() {
        if (isScreenON()) {
            // updates activity
            mb.setLastTime();
            if (!debugMode) {
                this.debugMode = true;
                mb.setDebugMode(true);
                sn.setDebugMode(debugMode);
                System.out.println("DEBUGGING MODE IS ON");
            } else {
                this.debugMode = false;
                mb.setDebugMode(false);
                sn.setDebugMode(false);
                System.out.println("DEBUGGING MODE IS OFF");
            }
        }
    }

    private String getBalance() {
        // updates activity
        mb.setLastTime();
        return (100 - balance) + "<-Left "
                + " Right->" + (100 - (100 - balance));
    }

    //Balance for speakers
    private void setBalance(int bal) {
        // updates activity
        mb.setLastTime();
        if (bal >= 0 && bal <= 100) {
            this.balance = bal;
            int l_bal = 100 - bal;
            int r_bal = 100 - l_bal;
            spk1.changeVol(
                    (volume * 2) * l_bal / 100
            );
            spk2.changeVol(
                    (volume * 2) * r_bal / 100
            );
        } else {
            System.out.println("INVALID ENTRY");
        }
    }

    // Method to mute/unmute the TV
    public void muteUnmute() {
        if (isScreenON()) {
            // updates activity
            mb.setLastTime();
            Speaker.muteUnmute();
        }
    }

    // Method to change Volume
    public void changeVolume() {
        if (isScreenON()) {
            // updates activity
            mb.setLastTime();
            System.out.println("Current Volume: " + volume);
            int vol = io.receiveIrSignal();
            if (vol >= 0 && vol <= 100) {
                this.volume = vol;
                setBalance(vol);
                System.out.println("VOLUME SET TO: " + volume);
            } else {
                System.out.println("INVALID ENTRY");
            }
        }
    }

    // Method to change contrast
    private void changeContrast(int contrast) {
        if (contrast >= 0 && contrast <= 100) {
            this.contrast = contrast;
            System.out.println("CONTRAST SET TO: " + contrast);
        } else {
            System.out.println("INVALID ENTRY");
        }
    }

    // Method to change Brightness
    private void changeBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
            System.out.println("BRIGHTNESS SET TO: " + brightness);
        } else {
            System.out.println("INVALID ENTRY");
        }
    }

    // Method to change Sharpness
    private void changeSharpness(int sharpness) {
        if (sharpness >= 0 && sharpness <= 100) {
            this.sharpness = sharpness;
            System.out.println("SHARPNESS SET TO: " + sharpness);
        } else {
            System.out.println("INVALID ENTRY");
        }
    }

    // Method to change Picture Mode for TV
    private void changePictureMode(int choice) {
        // updates activity
        mb.setLastTime();
        String[] modes = {"Standard", "Dynamic", "Mild"};
        java.util.Random rand = new java.util.Random();
        try {
            pictureMode = modes[choice];
        } catch (ArrayIndexOutOfBoundsException e) {
            pictureMode = modes[0];
            changeBrightness(50);
            changeContrast(50);
            changeSharpness(50);
            System.out.println("INVALID INPUT");
        }
        if (choice == 1) {
            changeBrightness(rand.nextInt(20, 81));
            changeContrast(rand.nextInt(20, 81));
            changeSharpness(rand.nextInt(20, 81));
        } else if (choice == 2) {
            changeBrightness(rand.nextInt(10, 50));
            changeContrast(rand.nextInt(10, 50));
            changeSharpness(rand.nextInt(10, 50));
        }
        System.out.println("PICTURE MODE SET TO: " + pictureMode);
    }

    //Method to change sound mode
    private void changeSoundMode(int choice) {
        // updates activity
        mb.setLastTime();
        String[] modes = {"Standard", "Music", "Movie", "Sports"};
        try {
            this.soundMode = modes[choice];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.soundMode = modes[0];
            System.out.println("INVALID INPUT");
        }
        System.out.println("SOUND MODE SET TO: " + soundMode);
    }

    // Method to change Input for TV
    public void changeInput() {
        if (isScreenON()) {
            // updates activity
            mb.setLastTime();
            System.out.println("Current Input: " + input);
            String[] inputs = {"TV", "AV", "HDMI", "DP", "USB"};
            System.out.println("1. TV\n2. AV " + (io.isAvSin() ? "*" : "")
                    + "\n3. HDMI " + (io.isHdmiSin() ? "*" : "")
                    + "\n4. DP " + (io.isDpSin() ? "*" : "")
                    + "\n5. USB " + (io.isUsbSin() ? "*" : "")
            );
            try {
                input = inputs[io.receiveIrSignal() - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                input = inputs[0];
                System.out.println("INVALID INPUT");
            }
            System.out.println("INPUT SET TO: " + input);
        }
    }

    // Auto sets input
    private void autoSetInput() {
        // updates activity
        mb.setLastTime();
        if (io.getCurrentInput().compareToIgnoreCase("None") == 0) {
            this.input = "TV";
        } else {
            this.input = io.getCurrentInput();
        }
    }

    //Method to show OSD/menu
    public void menu() {
        if (isScreenON()) {
            boolean loop = true;
            while (loop) {
                // updates activity
                mb.setLastTime();
                System.out.println("\n-------------------------------------------------");
                System.out.println("MENU");
                System.out.println("""
                        1. Picture
                        2. Sound
                        3. Time
                        4. Miscellaneous
                        5. Exit Main Menu"""
                );
                System.out.println("-------------------------------------------------\n");
                switch (io.receiveIrSignal()) {
                    case 1 -> {
                        //Picture
                        System.out.println("\n-------------------------------------------------");
                        System.out.println("Picture Settings");
                        System.out.println(
                                "Picture Mode: " + pictureMode
                                + "\nBrightness: " + brightness
                                + "\nContrast: " + contrast
                                + "\nSharpness: " + sharpness
                                + "\nRefresh rate: " + sn.getRefreshRate()
                        );
                        System.out.print("-------------------------------------------------");
                        boolean loop1 = true;
                        while (loop1) {
                            System.out.println("\n-------------------------------------------------");
                            System.out.println("\nSelect any one if you want to change value");
                            System.out.println("""
                                    1. Picture Mode
                                    2. Brightness
                                    3. Contrast
                                    4. Sharpness
                                    5. Refresh rate
                                    6. Go back to main menu""");
                            System.out.println("-------------------------------------------------\n");
                            switch (io.receiveIrSignal()) {
                                case 1 -> {
                                    //Picture Mode
                                    System.out.println("""
                                            1. Standard
                                            2. Dynamic
                                            3. Mild""");
                                    changePictureMode(io.receiveIrSignal() - 1);
                                }
                                case 2 -> {
                                    // Brightness
                                    System.out.println("Enter the new value");
                                    changeBrightness(io.receiveIrSignal());
                                }
                                case 3 -> {
                                    // Contrast
                                    System.out.println("Enter the new value");
                                    changeContrast(io.receiveIrSignal());
                                }
                                case 4 -> {
                                    // Sharpness
                                    System.out.println("Enter the new value");
                                    changeSharpness(io.receiveIrSignal());
                                }
                                case 5 -> {
                                    //Refresh rate
                                    System.out.println("Enter refresh rate\nOptions (24, 30 or 60)");
                                    int r = io.receiveIrSignal();
                                    if (r == 24 || r == 30 || r == 60) {
                                        sn.setRefreshRate(r);
                                    } else {
                                        sn.setRefreshRate(40);
                                        System.out.println("INVALID ENTRY");
                                    }
                                    System.out.println("REFRESH RATE SET TO: " + sn.getRefreshRate());
                                }
                                // to go back to main menu
                                case 6 ->
                                    loop1 = false;
                                default ->
                                    System.out.println("INVALID INPUT");

                            }
                        }
                    }
                    case 2 -> {
                        // Sound
                        System.out.println("\n-------------------------------------------------");
                        System.out.println("Sound Settings");
                        System.out.println("Sound Mode: " + soundMode
                                + "\nBalance: " + getBalance());
                        System.out.print("-------------------------------------------------");
                        boolean loop2 = true;
                        while (loop2) {
                            System.out.println("\n-------------------------------------------------");
                            System.out.println("Select any one if you want to change value");
                            System.out.println("""
                                    1. Sound Mode
                                    2. Balance
                                    3. Go back to main menu""");
                            System.out.println("-------------------------------------------------\n");
                            switch (io.receiveIrSignal()) {
                                case 1 -> {
                                    //Sound mode
                                    System.out.println("""
                                            1. Standard
                                            2. Music
                                            3. Movie
                                            4. Sports""");
                                    changeSoundMode(io.receiveIrSignal() - 1);
                                }
                                case 2 -> {
                                    //Balance
                                    System.out.println("Enter any value in range of 0 to 100");
                                    System.out.println("Enter above 50 for right side speaker");
                                    System.out.println("Enter below 50 for left side speaker");
                                    setBalance(io.receiveIrSignal());
                                }
                                case 3 ->
                                    loop2 = false;
                                default ->
                                    System.out.println("INVALID INPUT");
                            }
                        }
                    }
                    case 3 -> {
                        // Time

                        boolean loop3 = true;
                        while (loop3) {
                            System.out.println("\n-------------------------------------------------");
                            System.out.println("Time");
                            System.out.println("""
                                    1. Set Timer
                                    2. Turn off timer
                                    3. Current Time & Date
                                    4. Go back to main menu""");
                            System.out.println("-------------------------------------------------\n");
                            switch (io.receiveIrSignal()) {
                                case 1 -> {
                                    //set timer
                                    System.out.println("Enter time in minutes");
                                    setTimer();
                                }
                                //to turn off timer
                                case 2 ->
                                    turnOffTimer();
                                // gives Current Time & date
                                case 3 ->
                                    System.out.println(mb.time());

                                case 4 ->
                                    loop3 = false;
                                default ->
                                    System.out.println("INVALID INPUT");
                            }
                        }
                    }
                    case 4 -> {
                        // Miscellaneous
                        System.out.println("\n-------------------------------------------------");
                        System.out.println("Miscellaneous");
                        System.out.println("Debugging Mode: " + ((debugMode) ? "ON" : "OFF"));
                        System.out.print("-------------------------------------------------");
                        boolean loop4 = true;
                        while (loop4) {
                            System.out.println("\n-------------------------------------------------");
                            System.out.println("Select any one if you want to change value");
                            System.out.println("""
                                    1. Input
                                    2. Debugging Mode
                                    3. Info
                                    4. Go back to main menu""");
                            if (debugMode) {
                                System.out.println("""
                                        5. Reset Configuration
                                        6. Advanced Info""");
                            }
                            System.out.println("-------------------------------------------------\n");
                            switch (io.receiveIrSignal()) {
                                case 1 ->
                                    // Input
                                    changeInput();
                                case 2 ->
                                    // Debug mode
                                    on_Off_DebugMode();
                                case 3 ->
                                    // Info about Tv
                                    System.out.println(
                                            "Brand: " + brand
                                            + "\nModel: " + model
                                            + "\nResolution: " + sn.getHorizontalPixels() + " * " + sn.getVerticalPixels()
                                            + "\nRefresh rate: " + sn.getRefreshRate()
                                            + "\nSpeaker 1 Type: " + spk1.getType()
                                            + "\nSpeaker 2 Type: " + spk2.getType()
                                            + "\nMuted: " + ((Speaker.isMuted()) ? "YES" : "NO")
                                            + "\nVolume: " + volume
                                            + "\nBalance: " + getBalance()
                                            + "\nDate & Time: " + mb.time()
                                            + "\nCurrent Input: "
                                            + (io.getCurrentInput().compareToIgnoreCase("none") == 0 ? "TV" : io.getCurrentInput())
                                            + "\nCurrent Network: " + mb.getNetwork()
                                            + "\nDebugging Mode: " + ((debugMode) ? "ON" : "OFF")
                                    );

                                // go back to main menu
                                case 4 ->
                                    loop4 = false;
                                case 5 ->
                                    setConfiguration();
                                case 6 -> {
                                    if (debugMode) {
                                        // Advanced info
                                        System.out.println(
                                                "Brand: " + brand
                                                + "\nModel: " + model
                                                + "\nResolution: " + sn.getHorizontalPixels() + " * " + sn.getVerticalPixels()
                                                + "\nPixels Count: " + sn.getPixelCount()
                                                + "\nRefresh rate: " + sn.getRefreshRate()
                                                + "\nSpeaker 1 Type: " + spk1.getType()
                                                + "\nSpeaker 2 Type: " + spk2.getType()
                                                + "\nMuted: " + ((Speaker.isMuted()) ? "YES" : "NO")
                                                + "\nVolume: " + volume
                                                + "\nBalance: " + getBalance()
                                                + "\nDate & Time: " + mb.time()
                                                + "\nAV Port: " + ((io.isAvSin()) ? "C" : "NC")
                                                + "\nHDMI Port: " + ((io.isHdmiSin()) ? "C" : "NC")
                                                + "\nDP Port: " + ((io.isDpSin()) ? "C" : "NC")
                                                + "\nUSB Port: " + ((io.isUsbSin()) ? "C" : "NC")
                                                + "\nCurrent Input: "
                                                + (io.getCurrentInput().compareToIgnoreCase("none") == 0 ? "TV" : io.getCurrentInput())
                                                + "\nEthernet Port: " + ((io.isEthernet()) ? "C" : "NC")
                                                + "\nWIFI Connection: " + ((mb.isWifi()) ? "C" : "NC")
                                                + "\nCurrent Network: " + mb.getNetwork()
                                                + "\nScreen Temperature: " + (float) mb.getScreenTemp()
                                                + "\nSignal Quality: " + mb.getSignalQuality()
                                                + "\nDebugging Mode: " + ((debugMode) ? "ON" : "OFF")
                                        );
                                    } else {
                                        System.out.println("INVALID INPUT");
                                    }

                                }
                                default ->
                                    System.out.println("INVALID INPUT");
                            }
                        }
                    }
                    case 5 ->
                        loop = false;

                    default ->
                        System.out.println("INVALID INPUT");
                }
            }
        }
    }

    public void connect_DisconnectPower() {
        if (!io.isPower()) {
            io.setPower(true);
            System.out.println("Power connected");
        } else {
            io.setPower(false);
            System.out.println("Power disconnected");
        }
    }

    public void connect_DisconnectHdmiPort() {
        if (!io.isHdmiSin()) {
            io.setHdmiSin(true);
            System.out.println("HDMI connected");
        } else {
            io.setHdmiSin(false);
            System.out.println("HDMI disconnected");
        }
    }

    public void connect_DisconnectDpPort() {
        if (!io.isDpSin()) {
            io.setDpSin(true);
            System.out.println("Display port connected");
        } else {
            io.setDpSin(false);
            System.out.println("Display Port disconnected");
        }
    }

    public void connect_DisconnectUsbPort() {
        if (!io.isUsbSin()) {
            io.setUsbSin(true);
            System.out.println("USB connected");
        } else {
            io.setUsbSin(false);
            System.out.println("USB disconnected");
        }

    }

    public void connect_DisconnectAvPort() {
        if (!io.isAvSin()) {
            io.setAvSin(true);
            System.out.println("AV connected");
        } else {
            io.setAvSin(false);
            System.out.println("AV disconnected");
        }
    }

    public void connect_DisconnectOutHdmi() {
        if (!io.isOutHdmi()) {
            io.setOutHdmi(true);
            System.out.println("HDMI OUT connected");
        } else {
            io.setOutHdmi(false);
            System.out.println("HDMI OUT disconnected");
        }

    }

    public void connect_DisconnectEthernet() {
        if (!io.isEthernet()) {
            io.setEthernet(true);
            System.out.println("Ethernet connected");
        } else {
            io.setEthernet(false);
            System.out.println("Ethernet disconnected");
        }
    }

    public boolean isPowerON() {
        return io.isPower();
    }

}
