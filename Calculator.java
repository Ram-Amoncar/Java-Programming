
public class Calculator {

    public float a, b;
    private float results;
    private String oddOrEven;

    public void sumOfNumbers() {
        results = a + b;
    }

    public void differenceOfNumbers() {
        results = a - b;
    }

    public void divisionOfNumbers() {
        results = a / b;
    }

    public void multiplicationOfNumbers() {
        results = a * b;
    }

    public void modulusOfNumbers() {
        results = a % b;
    }

    public void factorialOfNumber() {
        results = 1;
        for (int i = (int) a; i > 1; i--) {
            results = results * i;
        }
    }

    public void checkOddOrEven() {
        oddOrEven = a % 2 == 0 ? "Even" : "Odd";
    }

    public void printResults() {
        System.out.println("Results: " + results);
    }

    public void printResultsForOddEven() {
        System.out.println("Results: " + oddOrEven);
    }
}
