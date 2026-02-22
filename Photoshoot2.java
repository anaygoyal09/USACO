import java.io.*;
import java.util.*;

public class Photoshoot2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        int[] pos = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            pos[val] = i;
        }

        int[] c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            c[i] = pos[val];
        }

        // Compute length of longest strictly increasing subsequence of c
        int[] tails = new int[N];
        int size = 0;
        for (int x : c) {
            int idx = lowerBound(tails, 0, size, x);
            if (idx == size) {
                tails[size++] = x;
            } else {
                tails[idx] = x;
            }
        }

        System.out.println(N - size);
    }

    // returns first index in tails[l..r-1] where tails[index] >= key
    private static int lowerBound(int[] tails, int l, int r, int key) {
        int lo = l, hi = r;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (tails[mid] >= key) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
