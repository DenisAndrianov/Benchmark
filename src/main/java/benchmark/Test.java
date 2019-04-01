package benchmark;

import java.util.*;

public class Test {
    int n = 100000;
    long time;

    public static void main (String[] args)   {
        new Test().start();
    }

    void start()    {
        test(new ArrayList(), "Array List");
        test(new LinkedList(), "Linked list");
        test(new HashSet(), "HashSet");
        test(new LinkedHashSet(), "LinkedHashSet");
        testMap(new HashMap<Integer,Integer>(), "HashMap");
        testMap(new TreeMap(), "TreeMap");
    }

    void test (Collection collection, String name)    {
        time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(i);
        }
        time = Math.abs(time - System.currentTimeMillis());
        System.out.println("На добавление "+n+" элементов в "+name+" ушло: "+time+" мс");

        time = System.currentTimeMillis();
        for (int i = n-1; i >= 0; i--) {
            collection.remove(i);
        }
        time = Math.abs(time - System.currentTimeMillis());
        System.out.println("На удаление "+n+" элементов в "+name+" ушло: "+time+" мс");
    }

    void testMap (Map map, String name) {
        time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            map.put(i,i);
        }
        time = Math.abs(time - System.currentTimeMillis());
        System.out.println("На добавление "+n+" элементов в "+name+" ушло: "+time+" мс");

        time = System.currentTimeMillis();
        for (int i = n-1; i >= 0; i--) {
            map.remove(i,i);
        }
        time = Math.abs(time - System.currentTimeMillis());
        System.out.println("На удаление "+n+" элементов в "+name+" ушло: "+time+" мс");
    }
}
