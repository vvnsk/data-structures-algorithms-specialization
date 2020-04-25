import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int coins = 0;
        final int[] types = new int[] { 10, 5, 1 };
        for (final int type : types) {
            coins += m / type;
            m = m % type;
            if (m == 0) {
                break;
            }
        }
        return coins;
    }

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
