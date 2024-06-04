package ExceptionHandling;

public class NegativeAmountException extends Exception {

    public NegativeAmountException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Negative Amount Inputted";
    }
}
