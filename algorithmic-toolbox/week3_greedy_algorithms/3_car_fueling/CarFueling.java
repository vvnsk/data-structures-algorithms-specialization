import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int tank, int n, int[] stops) {
        int numRefills = 0;
        int currentRefill = 0;
        while (currentRefill <= n) {
            int lastRefill = currentRefill;
            while (currentRefill <= n && stops[currentRefill + 1] - stops[lastRefill] <= tank) {
                currentRefill = currentRefill + 1;
            }
            if (currentRefill == lastRefill) {
                return -1;
            }
            if (currentRefill <= n) {
                numRefills = numRefills + 1;
            }
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        stops[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n + 1] = dist;

        System.out.println(computeMinRefills(tank, n, stops));
    }
}
