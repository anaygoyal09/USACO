
import java.util.Scanner;

public class TPrimes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            long sqrt = (long) Math.sqrt(num);
            if (sqrt * sqrt != num || num == 1) {
                System.out.println("NO");
                continue;
            }
            boolean isPrime = true;
            if (sqrt < 2) {
                isPrime = false;
            }
            for (long b = 2; b * b <= sqrt; b++) {
                if (sqrt % b == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("YES"); 
            }else {
                System.out.println("NO");
            }
        }
    }
}
