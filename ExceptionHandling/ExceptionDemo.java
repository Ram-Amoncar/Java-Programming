package ExceptionHandling;

public class ExceptionDemo {

    public static void main(String[] args) {
        int results = 0;
        System.out.println("Arithmetic Exception");
        try {
            results = 100 / 0;
        } catch (Exception e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
        System.out.println("Results: " + results);

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 5;
        }
        System.out.println("\nArray out of Bound Exception");
        try {
            for (int i = 0; i < 6; i++) {
                System.out.printf("arr[%d]: %d\n", i, arr[i]);
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
        System.out.println("Program Ends Here");
    }
}
