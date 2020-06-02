public class LSDSort {
    // LSD - List Significant Digit (по младшим разрядам)
    // Для строки длиной w,        O(wn)
    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256; // размер алфавита (count[R+1])
        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d -= 1) {

            int[] count = new int[R + 1];
            for (int i = 0; i < N; i += 1) {
                // подсчёт количества вхождений символа
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            } // counting index
            for (int i = 0; i < N; i++) {
                // размещение во вспомогательном массиве
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                // копорование
                a[i] = aux[i];
            }
        }
    }
}
