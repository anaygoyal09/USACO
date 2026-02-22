import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
public class Reflection {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int u = fs.nextInt();
        int half = n / 2;

        boolean[][] grid = new boolean[n][n];
        int[][] cnt = new int[half][half];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char ch = fs.nextGridChar();
                boolean painted = ch == '#';
                grid[r][c] = painted;
                if (painted) {
                    int a = Math.min(r, n - 1 - r);
                    int b = Math.min(c, n - 1 - c);
                    cnt[a][b]++;
                }
            }
        }

        long total = 0;
        for (int a = 0; a < half; a++) {
            for (int b = 0; b < half; b++) {
                int k = cnt[a][b];
                total += Math.min(k, 4 - k);
            }
        }

        StringBuilder out = new StringBuilder();
        out.append(total).append('\n');

        for (int i = 0; i < u; i++) {
            int r = fs.nextInt() - 1;
            int c = fs.nextInt() - 1;
            int a = Math.min(r, n - 1 - r);
            int b = Math.min(c, n - 1 - c);

            int oldCount = cnt[a][b];
            int oldCost = Math.min(oldCount, 4 - oldCount);

            boolean painted = grid[r][c];
            if (painted) {
                cnt[a][b]--;
            } else {
                cnt[a][b]++;
            }
            grid[r][c] = !painted;

            int newCount = cnt[a][b];
            int newCost = Math.min(newCount, 4 - newCount);
            total += newCost - oldCost;

            out.append(total).append('\n');
        }

        System.out.print(out.toString());
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        private FastScanner(InputStream input) {
            this.in = input instanceof BufferedInputStream ? input : new BufferedInputStream(input);
        }

        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        private int nextInt() {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        private char nextGridChar() {
            int c;
            do {
                c = read();
            } while (c == '\n' || c == '\r' || c == ' ' || c == '\t');
            return (char) c;
        }
    }
}
