import java.util.*;
import java.math.BigInteger;

public class FibonacciSumSquares {
    private static long[] getFibonacciHugeOptimized(long n) {
        if (n == 1) {
            return new long[] { 0, 1 };
        }

        BigInteger previous = new BigInteger("0");
        BigInteger current = new BigInteger("1");

        for (long i = 0; i < n - 1; i++) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
        }

        return new long[] { previous.mod(BigInteger.valueOf(10)).longValue(),
                current.mod(BigInteger.valueOf(10)).longValue() };
    }

    private static long[] getFibonacci(long n) {
        if (n == 1)
            return new long[] { 0, 1 };

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return new long[] { previous, current };
    }

    private static long getFibonacciSumSquaresOptimized(long n) {
        long[] fib = getFibonacciHugeOptimized(n + 1);
        long lengthLastDigit = fib[1];
        long fibLastDigit = fib[0];
        return (lengthLastDigit * fibLastDigit) % 10;
    }

    private static long getFibonacciSumSquaresFast(long n) {
        n = n % 60;
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; i++) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return ((current + previous) * current) % 10;
    }

    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}
