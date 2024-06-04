package MyCollections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> hMap = new HashMap<>();
        hMap.put(10, "Sam");
        hMap.put(20, "Jane");
        hMap.put(30, "Jill");
        hMap.put(40, "Kenny");
        hMap.put(50, "Nita");
        hMap.get(40);
        System.out.println(hMap);
        hMap.remove(20);
        for (Map.Entry<Integer, String> i : hMap.entrySet()) {
            System.out.println(i);
        }
        hMap.replace(40, "Jacob");

        System.out.println(hMap);
    }
}
