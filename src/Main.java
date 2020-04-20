import learn.BS;

import java.util.Arrays;

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
        int [] a = {4, 3, 2, 6};
        if (a.length < 10){
            for (int value : a) {
                System.out.print(value + " ");
            }
        }
        System.out.println("\nSum of " + a.length + " ropes = " + lb_4_Rope.getMinSum(a));
        System.out.println("\n***LB 4 END\n");
    }



    public static void main(String[] args) {

        LB_3_actions_BinaryHeap();

        LB_4_actions_RopeProblem();


    }

}
