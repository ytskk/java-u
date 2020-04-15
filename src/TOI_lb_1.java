
/*
gen nums 0 100
avg
disp
mo
* */

public class TOI_lb_1 {

    public static void random(int[] arr, int nOE) {
        System.out.println("****Expectation and  Variance****");
        double ran;
        for (int i = 0; i < nOE; i += 1) {
            ran = (int) (Math.random() * 100);
            arr[i] = (int) ran;
        }
    }

    public static void countMath(int[] arr, int nOE) {
        long sum = 0;
        double avg;
        for (int i = 0; i < nOE; i += 1) {
            sum += arr[i];
        }
        avg = sum / (double) nOE; // avg
        double disp = 0;
        for (int value : arr) {
            disp += (Math.pow(value - avg, 2));
        }
        disp /= (nOE - 1);
        System.out.format("\n***MO = %.3f, DISP = %.3f***", avg, disp);
    }


}
