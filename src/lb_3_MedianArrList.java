/*
 * Медиана в ряде через ArrayList
 * */

import java.util.ArrayList;

public class lb_3_MedianArrList {
    public static int m = 0;    // индекс медианы
    public static int odd = 0;    // нечётность
    // при 1 = 1, при 2 = 0

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

    public static void addNum(ArrayList<Integer> arr, int n) {
        arr.add(n);
        odd ^= 1;

        int N = arr.size() - 1;
        while (N > 0 && n < arr.get(N - 1)) {
            swap(arr, N - 1, N);
            N -= 1;
        }
        if (odd == 0) {
            m += 1;
        }
    }

    public static double getMedian(ArrayList<Integer> arr) {
        double med; // медиана

        if (odd == 0) {
            med = (double) (arr.get(m) + arr.get(m - 1)) / 2;
        } else {
            med = arr.get(m);
        }

        return med;
    }

}
