
import java.util.*;

public class Photoshoot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int Q = sc.nextInt();
        int[][] grid = new int[N][N];
        for (int q = 0; q < Q; q++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int v = sc.nextInt();
            grid[r][c] = v;

            int[][] psum = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    psum[i][j] = grid[i - 1][j - 1] + psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1];
                }
            }
            int max = 0;
            for (int i = K; i <= N; i++) {
                for (int j = K; j <= N; j++) {
                    int sum = psum[i][j] - psum[i - K][j] - psum[i][j - K] + psum[i - K][j - K];
                    max = Math.max(max, sum);
                }
            }
            System.out.println(max);
        }
    }
}
