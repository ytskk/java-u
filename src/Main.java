import java.util.Arrays;

public class Main {

    static void LB_3_BinaryHeap() {

        System.out.println("\n***LB 3 START\n");
//        int MAX = 1_000_000;
//        int[] a = new int[MAX];
//        for (int i = 0; i < MAX; i++) {
//            a[i] = StdRandom.uniform(1, 10);
//        }
        int[] a = {1, 7, 45, 8, 5};
        if (a.length < 10) {
            for (int value :
                    a) {
                StdOut.print(value + " ");
            }
        }

        System.out.println("\nMedian of " + a.length + " el. = " + lb_3_BinaryHeap.getMedian(a));
        System.out.println("\n***LB 3 END\n");
    } // work

    static void LB_4_RopeProblem() {

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
    } // work

    static void LB_5_BSTToMinPQ() {
        System.out.println("\n***LB 5 START\n");
        System.out.println("BST to MPQ");

        //filling
        ds_BST<Integer, Integer> bst = new ds_BST<>();

        // filling bst
//        int[] a = {18, 20, 29, 39, 47, 65, 66, 75, 77, 88};
//        for (int i = 0; i < 10; i++) {
//            bst.put(a[i], StdRandom.uniform(0, 100));
//        }
        bst.put(2, 2);
        bst.put(4, 2);
        bst.put(1, 2);
        bst.put(3, 2);
        bst.put(5, 2);


        System.out.println(bst.isBST());
        bst.printLevel();

        bst.BSTToMinHeap();
        System.out.println("Converted to MinPQ");
        bst.printLevel();
        System.out.println(bst.isBST());


        System.out.println("\n***LB 5 END\n");
    } // :(

    static void LB_6_IsBST() {
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
    } // work

    static void LB_7_FrequencySort() {
        System.out.println("\n***LB 7 START\n");


        System.out.println("Sorting strings by frequency");
        Comparable[] a = {"dwa", "s", "dwdsa2", "s", "s", "dwa"};
        System.out.println("UNSORTED ARRAY  :\t" + Arrays.toString(a));
        a = lb_7_htFrequencySort.htFrequencySort(a);
        System.out.println("SORTED ARRAY    :\t" + Arrays.toString(a));

        System.out.println("______________________________");

        System.out.println("Sorting integers by frequency");
        a = new Comparable[]{1, 2, 5, 67, 3, 76, 8, 3, 2, 2, 7, 8, 9};
        System.out.println("UNSORTED ARRAY  :\t" + Arrays.toString(a));
        a = lb_7_htFrequencySort.htFrequencySort(a);
        System.out.println("SORTED ARRAY    :\t" + Arrays.toString(a));


        System.out.println("\n***LB 7 END\n");
    } // work

    static void LB_8_Permutations() {
        System.out.println("\n***LB 8 START\n");


        String str = "ItIsHell";
        lb_8_permutations pmt = new lb_8_permutations();
        System.out.println("Next, you will find all " + pmt.getPermutationsFac(str) + " ways to rearrange the string \"" + str + "\" in ascending order.");
        pmt.letTheChaosBegin(str);


        System.out.println("\n***LB 8 END\nwe are saved)\n");
    } // work

    static void LB_9_Occurrences() {
        System.out.println("\n***LB 9 START\n");

        String FIND = "wis"; // to find

        char[][] matrix = generateMatrix(FIND);

        printMatrix(matrix);
        System.out.println("\n\"" + FIND + "\" can be found in " + lb_9_occurrences.count(matrix, FIND) + " ways");


        System.out.println("\n***LB 9 END\n");
    }

    private static char[][] generateMatrix(String text) {
        int generatedStringLength = StdRandom.uniform(text.length() + 1, (text.length() + 1) * 5); // length of matrix depends on FIND length

        char[][] matrix = new char[generatedStringLength][generatedStringLength];
        for (char[] chars : matrix) {
            double rand = StdRandom.uniform();
            char[] syms = (rand < 0.5)
                    ? ds_ht_StringSort.generateString(generatedStringLength).toCharArray()
                    : (rand > 0.75)
                    ? StringSearchClient.saltedRandomString(generatedStringLength, StdRandom.uniform(0, generatedStringLength - text.length()), text).toCharArray()
                    : StringSearchClient.saltedRandomString(generatedStringLength, StdRandom.uniform(0, generatedStringLength - text.length()), new StringBuilder(text).reverse().toString()).toCharArray();
            System.arraycopy(syms, 0, chars, 0, syms.length); // from, fromIndex, to, toIndex, count
        } // generates strings with secret word

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char el : chars) System.out.print(el + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {

        LB_3_BinaryHeap();

        LB_4_RopeProblem();

        LB_5_BSTToMinPQ();

        LB_6_IsBST();

        LB_7_FrequencySort();

        LB_8_Permutations();

        LB_9_Occurrences();

    }
}
