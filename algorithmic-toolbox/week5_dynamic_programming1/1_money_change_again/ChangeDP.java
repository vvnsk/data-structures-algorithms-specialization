import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] change = new int[m + 1];
        change[0] = 0;
        for (int i = 1; i < change.length; i++) {
            if (i == 1 || i == 3 || i == 4) {
                change[i] = 1;
                continue;
            }
            int min = 0;
            if (i >= 1) {
                int m1 = change[i - 1] + 1;
                min = m1;
            }
            if (i >= 3) {
                int m2 = change[i - 3] + 1;
                min = Math.min(min, m2);
            }
            if (i >= 4) {
                int m3 = change[i - 4] + 1;
                min = Math.min(min, m3);
            }
            change[i] = min;
        }
        return change[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
