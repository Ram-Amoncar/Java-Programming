package Helicopter;

import java.util.Scanner;

public class HelicopterDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;

        Helicopter h1 = new Helicopter();
        while (true) {
            System.out.println("0.Display Status\n1.Start Helicopter\n2.Ascend\n3.Descend\n4.Accelerate\n5.Decelerate\n6.Turn Left\n7.Turn Right\n8.Land\n9.Stop Helicopter\n10.Exit");
            option = sc.nextInt();
            switch (option) {
                case 0 ->
                    h1.displayStatus();
                case 1 ->
                    h1.start();
                case 2 ->
                    h1.ascend();
                case 3 ->
                    h1.descend();
                case 4 -> {
                    h1.incSpeed();
                    h1.goForward();
                }
                case 5 ->
                    h1.decSpeed();
                case 6 ->
                    h1.goLeft();
                case 7 ->
                    h1.goRight();
                case 8 ->
                    h1.land();
                case 9 ->
                    h1.stop();
                case 10 -> {
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}
