public class Main {

    public static void LB_3_actions_BinaryHeap() {

        int MAX = 1_000_000;
        int[] a = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            a[i] = StdRandom.uniform(1, 10);
        }
        Stopwatch st = new Stopwatch();
        lb_3_BinaryHeap.getMedian(a);
        System.out.println(MAX + " elapsed time: " + st.elapsedTime());

    }

    public static void LB_4_actions_RopeProblem() {

        int[] a = {4, 3, 2, 6};

        System.out.println(lb_4_Rope.getMinSum(a));
    }

    public static void main(String[] args) {

        LB_3_actions_BinaryHeap();

        LB_4_actions_RopeProblem();

    }
}
