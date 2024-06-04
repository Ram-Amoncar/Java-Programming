package TV;

// Package private class
final class Speaker {

    // Speaker instance
    private String type;
    private int volume;
    private static boolean muted;

    // Default constructor
    public Speaker() {
        setType("Stereo");
        setVolume(20);
        setMuted(false);
    }

    // Parameterized constructor
    public Speaker(String type) {
        this();
        setType(type);
    }

    // Method that Outputs Audio
    public void outputAudio(boolean audio, String sin) {
        if (audio) {
            if (sin.compareToIgnoreCase("none") != 0) {
                System.out.println(type + " Speaker Outputting Audio");
            }

        } else if (muted) {
            System.out.println("MUTE");
        }
    }

    // Method to change the Volume of the speaker
    public void changeVol(int vol) {
        if (vol > 0 && vol <= 100) {
            setVolume(vol);
        }
    }

    // Method to mute or unmute speaker
    public static void muteUnmute() {
        if (isMuted()) {
            setMuted(false);
            setMuted(false);
            System.out.println("UNMUTE");
        } else {
            setMuted(true);
            setMuted(true);
            System.out.println("MUTE");
        }
    }

    // Type of speaker
    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    // Volume
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //Mute Function
    public static boolean isMuted() {
        return muted;
    }

    public static void setMuted(boolean muted) {
        Speaker.muted = muted;
    }

}
