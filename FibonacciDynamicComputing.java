import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class FibonacciDynamicComputing {

    // **** constant(s) ****
    static final long MAX_FIB = 92;

    // **** global variable(s) ****
    static long count = 0;


    /**
     * Compute the specified Fibonacci number.
     * Recursive method.
     * Execution time: O(2 ^ n)
     */
    static long fibRecursive(long n) {

        // **** count this call ****
        count++;

        // **** end condition ****
        if (n <= 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        // **** recursion ****
        long fib = fibRecursive(n - 2) + fibRecursive(n - 1);

        // **** return fibonacci number ****
        return fib;
    }


    /**
     * Compute the specified Fibonacci number.
     * Using memoization.
     * Execution time:  O(2 * n + 1) = O(n)
     */
    static long fibMemo(long n, long[] memo) {

        // **** count this call ****
        count++;

         // **** end condition ****
        if (n == 0)
            return 0;

        // **** first two values ****
        if (n == 1 || n == 2)
            return 1;

        // **** check for value ****
        if (memo[(int)n] != 0)
            return memo[(int)n];

        // **** recursive ****
        long fib = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);

        // **** store in memo ****
        memo[(int)n] = fib;

        // **** return fibonacci number ****
        return fib;
    }


    /**
     * Compute the specified Fibonacci number.
     * Dynamci programming.
     * Bottom up approach.
     * Execution time: O(n)
     */
    static long fibBottomUp(long n) {

        // **** count this call ****
        count++;

        // **** end condition ****
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;
    
        // **** initialization ****
        long[] arr = new long[(int)n + 1];
        arr[1] = arr[2] = 1;

        // **** fill intermediate values ****
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        // **** return fibonacci number ****
        return arr[(int)n];
    }


    /**
     * Test scaffolding
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read which fibonnaci number to compute ****
        long n = Long.parseLong(sc.nextLine().trim());

        // **** close scanner ****
        sc.close();

        // **** check entered value ****
        if (n >= 0 && n <= MAX_FIB)
            System.out.println("main <<< n: " + n);
        else {
            System.out.println("main <<< invalid n: " + n);
            System.exit(-1);
        }

        // **** loop generating a set of Fibonacci numbers ****
        for (int i = 0; i <= n; i++) {

            // **** clear counter ****
            count = 0;

            // **** get start time ****
            long startTime = System.currentTimeMillis();

            // **** generate fibonacci number ****
            long fibNumber = fibRecursive(i);

            // **** get end time ****
            long endTime = System.currentTimeMillis();

            // **** display result ****
            System.out.println("main <<< count: " + count + " fibRecursive(" + i + "): " + fibNumber + " (" + (endTime - startTime) + " ms)");
        }
        System.out.println();

        // **** ****
        long[] memo = new long[(int)MAX_FIB + 1];

        // **** loop generating a set of Fibonacci numbers ****
        for (int i = 0; i <= n; i++) {

            // **** clear counter ****
            count = 0;
                        
            // **** initialize memo ****
            Arrays.fill(memo, 0);

            // **** get start time ****
            long startTime = System.nanoTime();

            // **** generate fibonacci number ****
            long fibNumber = fibMemo(i, memo);

            // **** get end time ****
            long endTime = System.nanoTime();

            // **** display result ****
            System.out.println("main <<< count: " + count + " fibMemo(" + i + "): " + fibNumber + " (" + (endTime - startTime) + " ns)");
        }
        System.out.println();

        // **** loop generating a set of Fibonacci numbers ****
        for (int i = 0; i <= n; i++) {

            // **** clear counter ****
            count = 0;

            // **** get start time ****
            long startTime = System.nanoTime();

            // **** generate fibonacci number ****
            long fibNumber = fibBottomUp(i);

            // **** get end time ****
            long endTime = System.nanoTime();

            // **** display result ****
            System.out.println("main <<< count: " + count + " fibBottomUp(" + i + "): " + fibNumber + " (" + (endTime - startTime) + " ns)");
        }
    
    }
}
