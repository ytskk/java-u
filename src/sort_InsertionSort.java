/*
 * Insertion sort
 * Стягиваем влево самое малое число из диапазона
 * из-за того, что j = i -> стягиваем каждый раз до предыдущего минимума + 1
 * */
public class sort_InsertionSort extends sort_AbctractSort implements sort_Sortable {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i += 1) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j -= 1) {
                exch(a, j, j - 1);
            }

        }
        /*
            a = 7 3 1 8 2 3 7 3 6 2 3
            i = 1
            a = 3 7 1 8 2 3 7 3 6 2 3
            i = 2
            a = 3 1 7 8 2 3 7 3 6 2 3
            a = 1 3 7 8 2 3 7 3 6 2 3


        * */
    }

}
