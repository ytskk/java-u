public class sort_IterativeMergeSort extends sort_AbctractSort implements sort_Sortable {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = 0; k <= hi; k += 1) {
            aux[k] = a[k];
        }
        for (int k = lo; k < hi; k += 1) {
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

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    /*
     *
     * MERGESORTEXAMPLE
     * sz = 1
     * EMGRESORETAXMPEL
     * sz = 2
     * EGMREORSAETXEMP
     * SZ = 4
     * EEGMORRSAEELMPTX
     * AEEEGLLMMOPRRSTX
     *
     * */
}
