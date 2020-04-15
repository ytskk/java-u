/*
 * SelectSort
 * Находим минимум и ставим его в самое левое созможное положение
 * */
public class sort_SelectSort extends sort_AbctractSort implements sort_Sortable {

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i += 1) {
            int min = i;
            for (int j = i + 1; j < N; j += 1) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
    /*
        exp. a = 7 3 5 0 2
        i = 0
        min = 0 (a[0] = 7)
        min = 3 (a[3] = 0)
        a = 0 3 5 7 2
        i = 1
        min = 1 (a[min] = 3)
        min = 6 (a[min] = 1)
        a = 0 2 5 7 3
     */
}
