package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            list.add(index, -1);             // random insertion
            list.remove(index);              // immediate random deletion
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        // Insertions at beginning and end
        for (int i = 0; i < OPERATIONS; i++) {
            if (list instanceof LinkedList) {
                LinkedList<Integer> linked = (LinkedList<Integer>) list;
                linked.addFirst(-1);
                linked.addLast(-1);
            } else {
                list.add(0, -1);
                list.add(-1);
            }
        }

        // Deletions at beginning and end
        for (int i = 0; i < OPERATIONS; i++) {
            if (list instanceof LinkedList) {
                LinkedList<Integer> linked = (LinkedList<Integer>) list;
                linked.removeFirst();
                linked.removeLast();
            } else {
                list.remove(0);
                list.remove(list.size() - 1);
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size());
            sum += list.get(index);  // random access
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

/*
Random insert/delete: ArrayList is faster because direct indexing allows quick access; LinkedList is slower due to traversal.


Sequential insert/delete at start/end: LinkedList is faster since it can adjust pointers in O(1); ArrayList must shift elements.


Random access (get by index): ArrayList is much faster because accessing by index is O(1); LinkedList must traverse nodes (O(n)).


Overall takeaway: Use ArrayList for fast access and mostly end operations, and LinkedList for frequent insertions or deletions at the start or end.


 */