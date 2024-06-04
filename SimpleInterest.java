
public class SimpleInterest {

    public static void main(String[] args) {
        int principle = 1200, rate = 5, time = 5;
        int simInterest = principle * time * rate / 100;
        System.out.println("Principal: " + principle + " Rate: " + rate + " Time: " + time);
        System.out.println("Final Amount: " + simInterest);
    }
}
