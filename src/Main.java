
public class Main {

    static void LB_3_actions_BinaryHeap() {

        System.out.println("\n***LB 3 START\n");
//        int MAX = 1_000_000;
//        int[] a = new int[MAX];
//        for (int i = 0; i < MAX; i++) {
//            a[i] = StdRandom.uniform(1, 10);
//        }
        int [] a = {1,7,45,8,5};
        if (a.length < 10){
            for (int value :
                    a) {
                StdOut.print(value + " ");
            }
        }

        System.out.println("\nMedian of " + a.length + " el. = " + lb_3_BinaryHeap.getMedian(a));
        System.out.println("\n***LB 3 END\n");
    }

    static void LB_4_actions_RopeProblem() {

        System.out.println("\n***LB 4 START\n");
//        int MAX = 1_000_000;
//        int[] a = new int[MAX];
//        for (int i = 0; i < MAX; i++) {
//            a[i] = StdRandom.uniform(1, 10);
//        }
        int[] a = {4, 3, 2, 6};
        if (a.length < 10) {
            for (int value : a) {
                System.out.print(value + " ");
            }
        }
        System.out.println("\nSum of " + a.length + " ropes = " + lb_4_Rope.getMinSum(a));
        System.out.println("\n***LB 4 END\n");
    }

    static void LB_5_actions_BSTToMinPQ() {
        System.out.println("\n***LB 5 START\n");
        System.out.println("BST to MPQ");

        //filling
        ds_BST<Integer, Integer> bst = new ds_BST<>();
        int[] a = {18, 20, 29, 39, 47, 65, 66, 75, 77, 88};
        for (int i = 0; i < 10; i++) {
            bst.put(a[i], StdRandom.uniform(0, 100));
        }

        System.out.println(bst.keys(0, 100));
        System.out.println(bst.isBST());
        bst.BSTToMinHeap();
        System.out.println(bst.keys(0, 100));
        System.out.println(bst.isBST());


        System.out.println("\n***LB 5 END\n");
    }

    static void LB_6_actions_isBST() {
        System.out.println("\n***LB 6 START\n");


        ds_BST<Integer, Integer> bst = new ds_BST<>();
        int[] a = {18, 20, 29, 39, 47, 65, 66, 75, 77, 88};
        for (int i = 0; i < 10; i++) {
            bst.put(a[i], StdRandom.uniform(0, 100));
        }
        System.out.println(bst.keys(0, 100));
        System.out.println(bst.isBST());
        bst.updateKey(20, 40);
        System.out.println("\n" + bst.keys(0, 100));
        System.out.println(bst.isBST());


        System.out.println("\n***LB 6 END\n");
    }

    static void LB_7_actions_FrequencySort() {
        int[] a = {1, 2, 5, 67, 3, 76, 8, 3, 2, 2, 7, 8, 9};
        lb_7_htFrequencySort.htFrequencySort(a);
    }

    public static void main(String[] args) {

        LB_3_actions_BinaryHeap();

        LB_4_actions_RopeProblem();

        LB_5_actions_BSTToMinPQ();

        LB_6_actions_isBST();

        LB_7_actions_FrequencySort();

    }
}
