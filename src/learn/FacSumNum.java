package learn;

public class FacSumNum {
    private static int factorial(int n) {
        int factorial = 1;
        while (n != 0) {
            factorial *= n;
            n -= 1;
        }
        return factorial;
    }

    // 1! + 4! + 5! = 145
    public static boolean isFacSum(int n) {
        int sum = 0;
        int tmp = n;
        while (tmp != 0) {
            sum += factorial(tmp % 10);
            tmp /= 10;
        }
        return (sum == n);
    }


}
