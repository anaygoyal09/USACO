
import java.io.*;
import java.util.*;

public class MakingMexes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] freq = new int[n + 2];
        for (int x : a) {
            if (x <= n) {
                freq[x]++;
            }
        }

        int surplus = 0;
        int need = 0;
        int[] ans = new int[n + 1];
        int totalSurplus = 0;
        int[] have = Arrays.copyOf(freq, n + 2);
        int ops = 0;
        for (int mex = 0; mex <= n; mex++) {
            if (mex > 0 && freq[mex - 1] == 0) {
                ans[mex] = -1;
                continue;
            }
            ans[mex] = ops + freq[mex];
            ops += freq[mex];
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
