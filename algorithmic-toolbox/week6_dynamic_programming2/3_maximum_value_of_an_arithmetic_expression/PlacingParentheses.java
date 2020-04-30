import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = exp.length() / 2 + 1;
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];
        long[] numbers = new long[n];
        char[] op = new char[n - 1];

        for (int i = 0; i < exp.length(); i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = (long) exp.charAt(i) - 48;
            } else {
                op[i / 2] = exp.charAt(i);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            m[i][i] = numbers[i];
            M[i][i] = numbers[i];
        }

        for (int s = 1; s < numbers.length; s++) {
            for (int i = 0; i < numbers.length - s; i++) {
                int j = i + s;
                long max_value = Long.MIN_VALUE;
                long min_value = Long.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    long a = eval(M[i][k], M[k + 1][j], op[k]);
                    long b = eval(M[i][k], m[k + 1][j], op[k]);
                    long c = eval(m[i][k], M[k + 1][j], op[k]);
                    long d = eval(m[i][k], m[k + 1][j], op[k]);
                    max_value = Math.max(max_value, Math.max(a, Math.max(b, Math.max(c, d))));
                    min_value = Math.min(min_value, Math.min(a, Math.min(b, Math.min(c, d))));
                }
                m[i][j] = min_value;
                M[i][j] = max_value;
            }
        }
        return M[0][numbers.length - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
