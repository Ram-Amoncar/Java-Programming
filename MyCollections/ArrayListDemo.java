package MyCollections;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        System.out.println("\nArrayList");
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            arrList.add(i * 9);
        }
        System.out.println("After inserting 10 elements");
        System.out.println("Size: " + arrList.size());
        System.out.println("Index of element 27: " + arrList.indexOf(27));
        arrList.set(0, 90);
        System.out.println("After setting value of index 0 to 90 value");
        System.out.println(arrList);
        arrList.add(1, 100);
        System.out.println("After adding 100 at index 1");
        System.out.println(arrList);
    }
}
