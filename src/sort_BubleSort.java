public class sort_BubleSort extends sort_AbctractSort implements sort_Sortable {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i += 1)
            for (int j = 0; j < N - i - 1; j += 1)
                if (less(a[j + 1], a[j]))
                    exch(a, j, j + 1);

    }
}
