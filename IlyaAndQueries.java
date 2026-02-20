import java.util.*;

public class IlyaAndQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if (s.charAt(i) == s.charAt(i - 1)) {
                prefix[i]++;
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(prefix[r - 1] - prefix[l - 1]);
        }
    }
}