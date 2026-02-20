
import java.util.Scanner;

public class KthNotDivisibleByN {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long k = in.nextLong();
            long ans = k + (k - 1) / (n - 1);
            System.out.println(ans);
        }
    }
}
