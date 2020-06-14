public class MSDSort {

    private static final int M = 15; // размер подмассива
    private static int R = 256; // размер алфавита (count[R+1])
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a, int w) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {

        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2];

        for (int i = lo; i <= hi; i += 1) {
            // подсчёт количества вхождений символа
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        } // counting index
        for (int i = lo; i <= hi; i++) {
            // размещение во вспомогательном массиве
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i < hi; i++) {
            // копорование
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1], d + 1);
        }
    }
}
