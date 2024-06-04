
import java.util.Scanner;

public class CalculatorDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        while (true) {
            System.out.println("\n\tMenu");
            System.out.println("1. Sum\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulus\n6. Factorial\n7. Odd or Even\n8. Exit");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.print("A: ");
                    cal.a = sc.nextInt();
                    System.out.print("B: ");
                    cal.b = sc.nextInt();
                    cal.sumOfNumbers();
                    cal.printResults();
                }
                case 2 -> {
                    System.out.print("A: ");
                    cal.a = sc.nextInt();
                    System.out.print("B: ");
                    cal.b = sc.nextInt();
                    cal.differenceOfNumbers();
                    cal.printResults();
                }
                case 3 -> {
                    System.out.print("A: ");
                    cal.a = sc.nextInt();
                    System.out.print("B: ");
                    cal.b = sc.nextInt();
                    cal.multiplicationOfNumbers();
                    cal.printResults();
                }
                case 4 -> {
                    System.out.print("A: ");
                    cal.a = sc.nextInt();
                    System.out.print("B: ");
                    cal.b = sc.nextInt();
                    cal.divisionOfNumbers();
                    cal.printResults();
                }
                case 5 -> {
                    System.out.print("A: ");
                    cal.a = sc.nextInt();
                    System.out.print("B: ");
                    cal.b = sc.nextInt();
                    cal.modulusOfNumbers();
                    cal.printResults();
                }
                case 6 -> {
                    System.out.print("num: ");
                    cal.a = sc.nextInt();
                    cal.factorialOfNumber();
                    cal.printResults();
                }
                case 7 -> {
                    System.out.print("num: ");
                    cal.a = sc.nextInt();
                    cal.checkOddOrEven();
                    cal.printResultsForOddEven();
                }
                case 8 -> {
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}
