
public class Calculator2Demo {

    public static void main(String[] args) {
        Calculator2 cal = new Calculator2();
        System.out.println("Addition");
        System.out.println("2+5 = " + cal.add(2, 5));
        System.out.println("2.25+7 = " + cal.add(2.25f, 7));
        System.out.println("11+3.39 = " + cal.add(11, 3.29f));
        System.out.println("35.27+10.80 = " + cal.add(35.27f, 10.80f));
        System.out.println("Subtraction");
        System.out.println("12-5 = " + cal.sub(12, 5));
        System.out.println("13.28-5 = " + cal.sub(13.28f, 5));
        System.out.println("18-9.36 = " + cal.sub(18, 9.36f));
        System.out.println("52.77-16.78 = " + cal.sub(52.77f, 16.78f));
        System.out.println("Multiplication");
        System.out.println("3*7 = " + cal.multi(3, 7));
        System.out.println("2.43*5 = " + cal.multi(2.43f, 5));
        System.out.println("Division");
        System.out.println("273/7 = " + cal.div(273, 7));
        System.out.println("389/2.5 = " + cal.div(389, 2.5f));
    }
}
