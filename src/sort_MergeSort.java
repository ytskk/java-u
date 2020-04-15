public class sort_MergeSort extends sort_AbctractSort implements sort_Sortable {
    /* иЗ ДВУХ ПОЛОВИНОК ОТСОРТИРОВАННЫХ получаем один упорядоченный массив за линейное время
     * 0 1 2 3 4   5 6 7 8 9
     * E E G M R | A C E R T
     *          ^         ^
     *          i         j
     * A C E E E   G M R R T
     * 0 1 2 3 4   5 6 7 8 9
     *
     * Нисходящая сортирровка
     * MERGESORTEXAPLE
     * MERGESOR   TEXAPMLE
     * MERG   ESOR   TEXA   MPLE
     * ME  RG  ES  OR  TE  XA  MP  LE
     * EM  GR  ES  OR ET  AX  MP  EL
     * EGRM  EORS  AETX  ELMP
     * EEGMORRS   AEELMPTX
     * AEEEEGLMMOPRRSTX
     * */

    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k += 1) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k += 1) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) // оставшиеся нужно добить из второй половины
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) // поместить эдементы из второй половины
                a[k] = aux[j++];
            else
                a[k] = aux[j++];
        }
    }

//    @Override
//    public void sort(Comparable [] a)
//    {
//        int N = a.length;
//        aux = new Comparable[N];
//        sort(a,0,a.length-1);
//    }


    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
}
