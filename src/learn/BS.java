package learn;

public class BS {
    public static int Iters(int key, int[] arr) {
        int start = 0;
        int stop = arr.length - 1;
        int count = 0;

        while (start <= stop) {
            int mid = start + (stop - start) / 2;
            count += 1;
            if (key > arr[mid]) start = mid + 1;
            else if (key < arr[mid]) stop = mid - 1;
            else break;
        }
        return count;

    }

}
