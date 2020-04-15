import java.io.FileWriter;
import java.io.IOException;


public class sort_SortTest { // доделать

    static void tests(String sortName, int MAX, sort_AbctractSort sort) throws IOException {

        FileWriter writer = new FileWriter("test.txt", true);
        writer.append("\nResults of ").append(sortName).append(" sort");

        for (int i = 0; i <= MAX; i += 5000) {
            if (testSort(sortName, i, sort) == 1)
                break;
//			if ( i > MAX/2  ) {
//				i += 3000;
//			}
        }


        writer.append("\n\n");
        writer.close();
    }

    public static void main(String[] args) throws IOException {

        int nOE = 1_000_00;

        sort_SelectSort s = new sort_SelectSort();
        sort_InsertionSort in = new sort_InsertionSort();
        sort_BubleSort b = new sort_BubleSort();
        sort_ShellSort sh = new sort_ShellSort();
        sort_MergeSort ms = new sort_MergeSort();
        sort_Merge m = new sort_Merge();

        sort_IterativeMergeSort ims = new sort_IterativeMergeSort();
        Stopwatch timer = new Stopwatch();

//		tests("bubble",nOE, b);
//		tests("insertion",nOE, in);
//		tests("selection",nOE, s);
//		tests("merge",nOE, m);
        tests("shell", nOE, sh);

        System.out.println("All sorts is ended it tooks " + timer.elapsedTime() + "s");

    }


    public static int testSort(String sortName, int MAX, sort_AbctractSort sort) throws IOException {

        FileWriter writer = new FileWriter("test.txt", true);

        double avgT = 0;
        double avgM = 0;
        System.out.println("***Sorting " + MAX + " elements, using " + sortName + " sort\n");
        for (int k = 0; k < 3; k += 1) {

//			System.out.println( "*** Generating input date..." );
            Date_[] a = new Date_[MAX];
            for (int i = 0; i < MAX; i += 1) {
                //			if ( i % ( MAX / 10 ) == 0 ) {
                //				System.out.print( "*" );
                //			}
                a[i] = new Date_();
                //			System.out.println(i+1 + ". " + a[i]); // debug
            }
//			System.out.println("***Sorting...");

            Stopwatch st = new Stopwatch();
            Runtime runtime = Runtime.getRuntime();
            long memory = runtime.totalMemory() - runtime.freeMemory();
            sort.sort(a);
            if (st.elapsedTime() > 5) { // if time > 5 sec (5 000 ms)
                System.out.printf("%d elements are too hard for %s sort\n", MAX, sortName);
                //			System.exit(0);
                return 1;
            }

            avgT += st.elapsedTime() * 1000;
            avgM += memory / 1024;
//			System.out.println("***Sorting is ended");
        }
        int numOfTests = 3;
        avgT /= numOfTests;
        avgM /= numOfTests;

//		System.out.println("Number os elements " + MAX+ " time "+ avgT + " memory "+ avgM + "\n");

//		writer.append("Elements: " + MAX + ". time "+ avgT + " memory "+ avgM + "\n");
//		writer.write(String.format( "Elements: %6d. Time: %8.3fms. Memory: %6.0fkb\n",MAX, avgT,avgM ));
        writer.append(String.format("%6.3f, ", avgT * 1.3));
        writer.close();
        return 0;
    }
}
