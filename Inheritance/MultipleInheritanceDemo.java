package Inheritance;

import java.util.Scanner;

public class MultipleInheritanceDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartCalculator smtCal = new SmartCalculator();
        while (true) {
            System.out.println("""
                    *****-----*****
                    1. Sum
                    2. Subtraction
                    3. Multiplication
                    4. Division
                    5. Square root
                    6. Factorial
                    7. Radians to degrees
                    8. Degrees to Radians
                    9. Exit""");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.println("Enter 2 numbers");
                    System.out.println("Results: "
                            + smtCal.sum(sc.nextDouble(), sc.nextDouble()));
                }
                case 2 -> {
                    System.out.println("Enter 2 numbers");
                    System.out.println("Results: "
                            + smtCal.sub(sc.nextDouble(), sc.nextDouble()));
                }
                case 3 -> {
                    System.out.println("Enter 2 numbers");
                    System.out.println("Results: "
                            + smtCal.multi(sc.nextDouble(), sc.nextDouble()));
                }
                case 4 -> {
                    System.out.println("Enter 2 numbers");
                    System.out.println("Results: "
                            + smtCal.div(sc.nextDouble(), sc.nextDouble()));
                }
                case 5 -> {
                    System.out.println("Enter a number");
                    System.out.println("Results: "
                            + smtCal.root(sc.nextDouble()));
                }
                case 6 -> {
                    System.out.println("Enter a number");
                    System.out.println("Results: "
                            + smtCal.fact(sc.nextInt()));
                }
                case 7 -> {
                    System.out.println("Enter Radians");
                    System.out.println("Degrees: "
                            + smtCal.toDegree(sc.nextDouble()));
                }
                case 8 -> {
                    System.out.println("Enter Degrees");
                    System.out.println("Radians: "
                            + smtCal.toRadians(sc.nextDouble()));
                }
                case 9 -> {
                    sc.close();
                    System.exit(0);
                }
                default ->
                    System.out.println("Invalid Input");
            }
        }
    }
}
