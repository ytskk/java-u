public class ds_MaxPQTest {

    public static void main(String[] args) {
        ds_MaxPQueue<Integer> maxPQueue = new ds_MaxPQueue<>();
        for (int i = 0; i < 100; i++) {
            System.out.println("maxPQueue.size() = " + maxPQueue.size());
            maxPQueue.insert(i);
            System.out.println("cap = " + maxPQueue.currCap);
        }
        System.out.println("\n\n\n****Decreasing");
        for (int i = 0; i < 100; i++) {
            System.out.println("maxPQueue.size() = " + maxPQueue.size());
            maxPQueue.delMax();
            System.out.println("cap = " + maxPQueue.currCap);
        }
//        maxPQueue.insert(10);
//        maxPQueue.insert(5);
//        maxPQueue.insert(7);
//        maxPQueue.insert(4);
//        maxPQueue.insert(3);
//        maxPQueue.insert(5);
//        maxPQueue.insert(6);
//        maxPQueue.printQueue();
//        System.out.println("Deep is " + maxPQueue.deep());
//
//        ds_MinPQueue<Integer> minPQueue = new ds_MinPQueue<>(10);
//        minPQueue.insert(10);
//        minPQueue.insert(5);
//        minPQueue.insert(7);
//        minPQueue.insert(4);
//        minPQueue.insert(3);
//        minPQueue.insert(5);
//        minPQueue.insert(6);
//        minPQueue.printQueue();
//        maxPQueue.size();
//        maxPQueue.insert(2);
//        maxPQueue.delMax();


//        for (int i = 0; i < 100; i++) {
//            Date_ d = new Date_();
//            maxPQueue.insert(d);
//            StdOut.println(d.toString() + " добавлена в очередь");
//            StdOut.println("Max = " + maxPQueue.peekMax());
//
//        }
//        StdOut.println("*********************************");
//        MaxPQueue<Integer> mpq = new MaxPQueue<>(20);
//        for (int i = 0; i < 20; i++) {
//            int a =StdRandom.uniform(-20,20);
//            System.out.println("*** Add element a = " + a);
//            mpq.insert(a);
//            System.out.println("*** Queue on step " + i + ":");
//
//            mpq.printQueue();
//        }
//        while (!mpq.isEmpty())
//            System.out.println(mpq.delMax());

    }
}
