import TV.Television;
import java.util.Scanner;

public class TV_Client {
    public static void main(String[] args) {

        Television tv;
        tv = new Television();

        Scanner sc = new Scanner(System.in);
        int var;
        outer:
        while (true) {
            System.out.println("\n-------------------------------------------------");
            System.out.println("Television Exterior Features");
            System.out.println("""
                    1. On/Off Power TV
                    2. HDMI   3. AV
                    4. DP     5. USB
                    6. Ethernet
                    7. TV Remote
                    8. Exit""");
            System.out.println("-------------------------------------------------\n");
            try {
                var = sc.nextInt();
            } catch (Exception e) {
                var = 999;
            }
            switch (var) {
                case 1 -> {
                    tv.connect_DisconnectPower();
                }
                case 2 -> {
                    tv.connect_DisconnectHdmiPort();
                }
                case 3 -> {
                    tv.connect_DisconnectAvPort();
                }
                case 4 -> {
                    tv.connect_DisconnectDpPort();
                }
                case 5 -> {
                    tv.connect_DisconnectUsbPort();
                }
                case 6 -> {
                    tv.connect_DisconnectEthernet();
                }
                case 7 -> {
                    inner:
                    {
                        while (true) {
                            System.out.println("\n-------------------------------------------------");
                            System.out.println("TV Remote");
                            System.out.println("""
                                    1. Power ON/OFF Screen     2. Mute/Un-mute
                                    3. Change Input            4. Show(Output)
                                    5. Menu                    6. Change Channel
                                    7. Volume                  8. Debug Mode (On/Off)
                                    9. Go back to Television Exterior menu""");
                            System.out.println("-------------------------------------------------\n");
                            if (tv.isPowerON()) {
                                try {
                                    var = sc.nextInt();
                                } catch (Exception e) {
                                    var = 999;
                                    continue;
                                }
                                switch (var) {
                                    case 1 -> tv.turnOnOffScreen();
                                    case 2 -> tv.muteUnmute();
                                    case 3 -> tv.changeInput();
                                    case 4 -> tv.show();
                                    case 5 -> tv.menu();
                                    case 6 -> tv.changeChannel();
                                    case 7 -> tv.changeVolume();
                                    case 8 -> tv.on_Off_DebugMode();
                                    case 9 -> {
                                        break inner;
                                    }
                                    default -> {
                                        System.out.println("Unknown Input");
                                        break inner;
                                    }
                                }
                            } else {
                                System.out.println("TV is not powered");
                                break inner;
                            }
                        }
                    }
                }
                case 8 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Unknown Input");
                    break outer;
                }
            }
        }
    }
}
