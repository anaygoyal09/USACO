import java.util.*;
public class SameDifferences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            
            int offset = n + 5;
            long[] freq = new long[2 * n + 10];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int key = a[i] - i + offset;
                ans += freq[key];
                freq[key]++;
            }
            System.out.println(ans);
        }
    }
}
