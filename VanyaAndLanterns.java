
import java.util.Scanner;

public class VanyaAndLanterns {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        java.util.Arrays.sort(a);
        double maxGap = 0;
        for (int i = 1; i < n; i++) {
            maxGap = Math.max(maxGap, a[i] - a[i - 1]);
        }
        // The largest gap between lanterns, divided by 2
        double d = maxGap / 2.0;
        // Check the distance from 0 to the first lantern and last lantern to l
        d = Math.max(d, a[0] - 0);
        d = Math.max(d, l - a[n - 1]);
        System.out.printf("%.10f\n", d);
    }
}
