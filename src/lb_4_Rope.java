public class lb_4_Rope {


    /*
     * n
     * 4 3 2 6
     * 2 + 3 = 5
     * 4 6 5
     * 4 + 5 = 9
     * 6 9
     * 6 + 9 = 15
     * 15
     *
     * alg
     * -> 4 3 2 6
     * 6 4 3 2
     *        6
     *       /-\
     *      4   3
     *     /-\ /-\
     *    2
     *  1)                       2)                  3)                      4)
     *         6          6          6         9         (9)          15         (15)
     *       /-\        /-\        /-\       /-\        /-\         /-\         /-\
     *      4  (3)     4   5     (4) (5)    6         (6)
     *     /-\ /-\
     *   (2)
     * -> 2 + 3 = 5             -> 4 + 5 = 9        -> 9 + 6 = 15           -> 15
     *  sum = 0 + 5             sum = 5 + 9         sum = 14 + 15
     *
     * 3)   (9)
     *      /-\
     *    (6)
     * -> 9 + 6 = 15
     * 4)
     *      (15)
     *
     *
     *
     *
     * */
    public static int getMinSum(int[] a) {
        ds_MaxPQueue<Integer> pq = new ds_MaxPQueue<>();
        int sum = 0;
        int returning = 0;

        // filling PQ
        for (int value : a) {
            System.out.println("size = " + pq.size());
            pq.insert(value);
        }

        for (int i = 0; i < pq.size() + 1; i++) {
            returning = pq.delLast() + pq.delLast();
            sum += returning;
            pq.insert(returning);
        }

        return sum;
    }
}
