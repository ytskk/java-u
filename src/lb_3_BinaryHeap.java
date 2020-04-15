public class lb_3_BinaryHeap {

    public static double getMedian(int[] arr) {

        ds_MinPQueue<Integer> smallerPQ = new ds_MinPQueue<>();
        ds_MaxPQueue<Integer> greaterPQ = new ds_MaxPQueue<>();

        double mid = 0;

        for (int i = 0; i < arr.length; i++) {

            int x = arr[i];

            if (greaterPQ.size() == smallerPQ.size()) {
                if (x < mid) {
                    greaterPQ.insert(x);
                    mid = greaterPQ.peekMax();
                } else {
                    smallerPQ.insert(x);
                    mid = smallerPQ.peekMax();
                }
            } else if (greaterPQ.size() > smallerPQ.size()) {
                if (x < mid) {
                    smallerPQ.insert(greaterPQ.delMax());
                    greaterPQ.insert(x);
                } else {
                    smallerPQ.insert(x);
                }
                mid = (double) (greaterPQ.peekMax() + smallerPQ.peekMax()) / 2;
            } else if (greaterPQ.size() < smallerPQ.size()) {
                if (x > mid) {
                    greaterPQ.insert(smallerPQ.delMax());
                    smallerPQ.insert(x);
                } else {
                    greaterPQ.insert(x);
                }
                mid = (double) (greaterPQ.peekMax() + smallerPQ.peekMax()) / 2;
            }
        }
        return mid;
    }

}
