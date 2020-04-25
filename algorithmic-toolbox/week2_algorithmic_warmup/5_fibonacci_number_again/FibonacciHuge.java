import java.util.*;
import java.math.BigInteger;

public class FibonacciHuge {
    private static long pisanoPeriod(long m) {
        long previous = 0;
        long current = 1;

        for (long i = 0; i < m * m; i++) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }
        return m;
    }

    private static long getFibonacciHugeOptimized(long n, long m) {
        long pisano_period = pisanoPeriod(m);
        n = n % pisano_period;

        if (n == 0) {
            return 0;
        }

        BigInteger previous = new BigInteger("0");
        BigInteger current = new BigInteger("1");

        for (long i = 0; i < n - 1; i++) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
        }

        return (current.mod(BigInteger.valueOf(m))).longValue();
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeOptimized(n, m));
    }
}
