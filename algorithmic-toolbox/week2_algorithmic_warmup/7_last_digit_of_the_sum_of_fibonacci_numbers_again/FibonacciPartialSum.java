import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacci(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current;
    }

    private static long getFibonacciSumLastDigit(long n) {
        return (getFibonacci(n + 2) - 1) % 10;
    }

    private static long getFibonacciPartialSumOptimized(long from, long to) {
        long lastDigit = (getFibonacciSumLastDigit(to) - getFibonacciSumLastDigit(from - 1));
        if (lastDigit < 0) {
            return 10 + lastDigit;
        }
        return lastDigit;
    }

    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumOptimized(from, to));
    }
}
