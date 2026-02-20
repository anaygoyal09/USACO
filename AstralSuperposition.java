import java.io.*;
import java.util.*;

public class AstralSuperposition {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken()); // shift right (columns)
            int B = Integer.parseInt(st.nextToken()); // shift down (rows)

            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }

            boolean impossible = false;

            // forced[i][j] = true if G pixel (i,j) must have photo1=1
            // because it is the predecessor of a B pixel
            boolean[][] forced = new boolean[N][N];

            // Check validity: for every B pixel at (i,j),
            //   predecessor (i-B, j-A) must exist and not be W.
            for (int i = 0; i < N && !impossible; i++) {
                for (int j = 0; j < N && !impossible; j++) {
                    if (grid[i][j] == 'B') {
                        int pi = i - B, pj = j - A;
                        if (pi < 0 || pi >= N || pj < 0 || pj >= N) {
                            // photo2[i][j]=1 but predecessor out of bounds
                            impossible = true;
                        } else if (grid[pi][pj] == 'W') {
                            // predecessor has photo1=0, can't supply photo2=1
                            impossible = true;
                        } else if (grid[pi][pj] == 'G') {
                            // predecessor is G: force it to photo1=1
                            forced[pi][pj] = true;
                        }
                        // predecessor == 'B': already photo1=1, fine
                    }
                }
            }

            if (impossible) {
                sb.append(-1).append('\n');
                continue;
            }

            int totalStars = 0;

            // Count B pixels (always contribute one star each to photo1)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 'B') totalStars++;
                }
            }

            // Process G pixels: find chains along the shift direction and DP
            // Chain: G[0], G[1], ..., G[k-1] where G[t+1] = G[t] + (B rows, A cols)
            // Chain start: a G pixel whose predecessor (i-B, j-A) is not a G pixel
            //              (i.e., out of bounds, W, B pixel, or would be the same pixel)
            boolean[][] visited = new boolean[N][N];
            final int INF = Integer.MAX_VALUE / 2;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] != 'G' || visited[i][j]) continue;

                    // Determine if this is a chain start
                    int pi = i - B, pj = j - A;
                    boolean samePixel = (pi == i && pj == j); // A=B=0 case
                    boolean predIsG = !samePixel
                            && pi >= 0 && pi < N && pj >= 0 && pj < N
                            && grid[pi][pj] == 'G';

                    if (predIsG) continue; // not a chain start; will be visited later

                    // Build the chain forward
                    // chainLength: collect positions
                    // Also determine if predecessor of G[0] is a B pixel (predIsOne)
                    boolean predIsOne = false;
                    if (!samePixel && pi >= 0 && pi < N && pj >= 0 && pj < N
                            && grid[pi][pj] == 'B') {
                        predIsOne = true;
                    }

                    // DP along the chain
                    // dp0 = min stars if current G pixel has photo1=0
                    // dp1 = min stars if current G pixel has photo1=1
                    int dp0, dp1;

                    boolean firstForced = forced[i][j];
                    if (firstForced) {
                        // Must have photo1=1
                        dp0 = INF;
                        dp1 = 1;
                    } else if (samePixel) {
                        // A=B=0: photo2[i][j]=1 would need photo1[i][j]=1 (self-loop) → impossible
                        dp0 = INF;
                        dp1 = 1;
                    } else {
                        // Can choose 0 if predecessor is photo1=1
                        dp0 = predIsOne ? 0 : INF;
                        dp1 = 1;
                    }

                    visited[i][j] = true;
                    int ci = i + B, cj = j + A;

                    while (ci >= 0 && ci < N && cj >= 0 && cj < N && grid[ci][cj] == 'G' && !visited[ci][cj]) {
                        visited[ci][cj] = true;
                        int new_dp0, new_dp1;
                        boolean curForced = forced[ci][cj];
                        if (curForced) {
                            // Must have photo1=1: need predecessor dp to be valid
                            new_dp0 = INF;
                            int best = Math.min(dp0, dp1);
                            new_dp1 = (best < INF) ? best + 1 : INF;
                        } else {
                            // photo1=0: predecessor must have photo1=1
                            new_dp0 = (dp1 < INF) ? dp1 : INF;
                            // photo1=1: predecessor can be anything
                            int best = Math.min(dp0, dp1);
                            new_dp1 = (best < INF) ? best + 1 : INF;
                        }
                        dp0 = new_dp0;
                        dp1 = new_dp1;

                        ci += B;
                        cj += A;
                    }

                    int chainMin = Math.min(dp0, dp1);
                    if (chainMin >= INF) {
                        impossible = true;
                        break;
                    }
                    totalStars += chainMin;
                }
                if (impossible) break;
            }

            sb.append(impossible ? -1 : totalStars).append('\n');
        }

        System.out.print(sb);
    }
}
