import java.util.*;

public class Knapsack {
  static int optimalWeight(int W, int[] w) {
    int i, j;
    int[][] M = new int[w.length + 1][W + 1];
    for (i = 1; i <= w.length; i++) {
      for (j = 1; j <= W; j++) {
        if (w[i - 1] > j) {
          M[i][j] = M[i - 1][j];
        } else {
          M[i][j] = Math.max(w[i - 1] + M[i - 1][j - w[i - 1]], M[i - 1][j]);
        }
      }
    }
    return M[w.length][W];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
  }
}
