package ExceptionHandling;

public class MinimumBalanceException extends Exception {

    public MinimumBalanceException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Minimum Balance of 1000 should be Maintained";
    }
}
