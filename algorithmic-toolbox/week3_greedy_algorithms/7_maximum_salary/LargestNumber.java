import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        // write your code here
        String result = "";
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
