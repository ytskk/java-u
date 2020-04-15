public class sort_ShellSort extends sort_AbctractSort implements sort_Sortable {
    /*
     * ex.
     * LEEAMHLESPOLTSXR
     * выбираем h - шаг через который берутся новые символы для подпоследовательности
     * h = 13 (0 и 12 символ)
     * SHELLSORTEXAMPLE
     * S            M
     *  H             P
     *    E            L
     *      L            EA
     * h = 4
     * M   L   T   S
     *   H   S   E   P
     *     E   O   X   L
     *       E   R   A   L
     * h = 1
     * LEEAMHLESPOLTSXR
     * дальше обычной вставкой
     * */

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;    // 121, 40, 12, 4, 1
        }
        while (h >= 1) {
            for (int i = h; i < N; i += 1) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;

        }

    }

}
