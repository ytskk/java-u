public abstract class sort_AbctractSort {
    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i += 1) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public void sort(Comparable[] a) {
    }
}
