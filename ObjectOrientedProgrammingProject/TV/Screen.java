package TV;

// Package private class
final class Screen {

    // Screen instance variables
    private static class resolution {

        private static int horizontalPixels;

        private static int verticalPixels;
    }
    private long pixelCount;
    private boolean on;
    private int refreshRate;
    private boolean debugMode;

    // Non Parameterized Constructor
    public Screen() {
        setOn(false);
        setRefreshRate(30);
        setResolution(1920, 1080);
        setPixelCount(getHorizontalPixels() * getVerticalPixels());
        setDebugMode(false);
    }

    // Parameterized Constructor
    //1080p is 1920*1080
    //2K is 2048*1080
    //4K is 3840*2160
    public Screen(int horizontalPixels, int verticalPixels) {
        this();
        setResolution(horizontalPixels, verticalPixels);
        setPixelCount(horizontalPixels * verticalPixels);
    }

    // To turn on the Screen
    public void turnOn() {
        if (!on) {
            if (debugMode) {
                Motherboard.process("Turning On", 500);
            } else {
                Motherboard.delay(4000);
            }
            setOn(true);
        }
    }

    //To turn off the Screen
    public void turnOff() {
        if (on) {
            if (debugMode) {
                Motherboard.process("Turning Off", 0);
            }
            setOn(false);
        }
    }

    //To check if screen is on
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    //  To display Image on screen
    public void display(boolean image, String sin) {
        if (image) {
            if (sin.compareToIgnoreCase("none") == 0) {
                System.out.println("NO SIGNAL");
            } else {
                System.out.println("IMAGE");
            }
        }
    }

    // Pixel Count
    public long getPixelCount() {
        return pixelCount;
    }

    private void setPixelCount(int pixelCount) {
        this.pixelCount = pixelCount;
    }

    //Refresh Rate
    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    //Debugger Mode
    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    //Resolution
    private static void setResolution(int horizontalPixels, int verticalPixels) {
        resolution.horizontalPixels = horizontalPixels;
        resolution.verticalPixels = verticalPixels;
    }

    public int getHorizontalPixels() {
        return resolution.horizontalPixels;
    }

    public int getVerticalPixels() {
        return resolution.verticalPixels;
    }

}
