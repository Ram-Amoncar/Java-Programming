package Helicopter;

public final class Helicopter {

    protected int speed;
    protected int height;
    private String model;
    Engine e1 = new Engine();
    MainRotor m1 = new MainRotor();
    TailRotor t1 = new TailRotor();

    public Helicopter() {
        speed = 0;
        height = 0;
        setModel("");

    }

    public Helicopter(String model) {
        speed = 0;
        height = 0;
        this.setModel(model);
    }

    public void start() {
        if ("off".equals(e1.getEngineStatus())) {

            e1.setEngineStatus("on");

            m1.setRotorStatus("spinning");
            m1.setMainRPM(500);
            t1.setTailRotorStatus("spinning");
            t1.setTailRPM(3000);
            System.out.println("Helicopter Started");
        } else {
            System.out.println("Helicopter already running");
        }

    }

    public void stop() {

        if (height > 0) {
            System.out.println("Land Helicopter First");
        } else {
            if (!"on".equals(e1.getEngineStatus())) {
                System.out.println("Helicopter already stopped");
            } else {
                speed = 0;
                e1.setEngineStatus("off");

                m1.setRotorStatus("off");
                m1.setMainRPM(0);
                t1.setTailRotorStatus("off");
                t1.setTailRPM(0);
                System.out.println("Helicopter Stopped");
            }
        }

    }

    public void ascend() {
        if ("spinning".equals(m1.getRotorStatus())) {
            height = height + 10;
            System.out.println("Helicopter is now at: " + height + "m");
        } else {
            System.out.println("Start Engine First");
        }

    }

    public void descend() {

        if (height == 0) {
            System.out.println("Helicopter Already On The Ground");
        } else {
            height = height - 10;
        }

        System.out.println("Helicopter is now at: " + height + "m");

    }

    public void goLeft() {
        if (height > 0) {
            System.out.println("Going Left");
        } else {
            System.out.println("Helicopter must be off the ground");
        }
    }

    public void goRight() {
        if (height > 0) {
            System.out.println("Going Right");
        } else {
            System.out.println("Helicopter must be off the ground");
        }
    }

    public void goForward() {
        if (height > 0) {
            System.out.println("Going Forward");
        } else {
            System.out.println("Helicopter must be off the ground");
        }
    }

    public void goBack() {
        if (height > 0) {
            System.out.println("Going Back");
        } else {
            System.out.println("Helicopter must be off the ground");
        }
    }

    public void incSpeed() {
        if (height > 0) {
            speed = speed + 10;
            System.out.println("Helicopter is now at a speed of: " + speed + " knots");
        } else {
            System.out.println("Helicopter must be off the ground");
        }
    }

    public void decSpeed() {
        if (height > 0) {
            if (speed <= 0) {
                speed = speed - 10;
                System.out.println("Helicopter is now going backwards at a speed of: " + (-speed) + " knots");

            } else {
                speed = speed - 10;
                System.out.println("Helicopter is now at a speed of: " + speed + " knots");
            }
        } else {
            System.out.println("Helicopter must be off the ground");
        }
    }

    public void land() {
        speed = 0;
        height = 0;
        System.out.println("Helicopter is now at a speed of: " + speed + " knots");
        System.out.println("Helicopter is now at: " + height + "m");
        System.out.println("Helicopter Landed");

    }

    public void displayStatus() {
        System.out.println("Engine Status: " + e1.getEngineStatus());
        System.out.println("Main Rotor is " + m1.getRotorStatus() + " at " + m1.getMainRPM() + " RPM");
        System.out.println("Tail Rotor is " + t1.getTailRotorStatus() + " at " + t1.getTailRPM() + " RPM");
        System.out.println("Speed: " + speed + " knots");
        System.out.println("Height: " + height + "m");

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
