package MyCollections;

import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);
        list.addFirst(100);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        list.addLast(200);
        System.out.println("\nSize: " + list.size());
        System.out.println("Peek: " + list.peek());
        System.out.println("After setting 5th element as 400");
        list.set(4, 400);
        list.forEach(System.out::println);
    }
}
