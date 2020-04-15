
public class Main {

    static void LB_3_actions_BinaryHeap() {

        System.out.println("\n***LB 3 START\n");
        int MAX = 1_000_000;
        int[] a = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            a[i] = StdRandom.uniform(1, 10);
        }

        System.out.println("Median of " + MAX + " el. = " + lb_3_BinaryHeap.getMedian(a));
        System.out.println("\n***LB 3 END\n");
    }

    static void LB_4_actions_RopeProblem() {

        System.out.println("\n***LB 4 START\n");
        int MAX = 1_000_000;
//        int [] a = {4, 3, 2, 6};
        int[] a = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            a[i] = StdRandom.uniform(1, 10);
        }

        System.out.println("Sum of " + MAX + " ropes = " + lb_4_Rope.getMinSum(a));
        System.out.println("\n***LB 4 END\n");
    }

    public static void main(String[] args) {

        LB_3_actions_BinaryHeap();

        LB_4_actions_RopeProblem();

    }
}
