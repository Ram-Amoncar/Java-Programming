package Inheritance;

public class SmartCalculator implements ISimpleCalculator, IScientificCalculator {

    @Override
    public int fact(int x) {
        int f = 1;
        for (int i = 1; i <= x; i++) {
            f *= i;
        }
        return f;
    }

    @Override
    public double root(double x) {
        return Math.sqrt(x);
    }

    @Override
    public double toRadians(double deg) {
        return deg * Math.PI / 180;
    }

    @Override
    public double toDegree(double rad) {
        return rad * 180 / Math.PI;
    }

    @Override
    public double sum(double x, double y) {
        return x + y;
    }

    @Override
    public double sub(double x, double y) {
        return x - y;
    }

    @Override
    public double multi(double x, double y) {
        return x * y;
    }

    @Override
    public double div(double x, double y) {
        return x / y;
    }
}
