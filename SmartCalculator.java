
public class SmartCalculator {

    private final double principle = 1200.00;
    private final double rate = 5;
    private final double time = 3;
    private double simpleInterest = 0.00;

    public void findSimpleInterest() {
        simpleInterest = principle * time * rate / 100;
    }

    public void displayResult() {
        System.out.println("The Simple Interest is " + simpleInterest);
    }
}
