
import java.util.Scanner;

public class CheapTravel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int cost = 0;

        if ((double) b / m < a) {
            cost += (n / m) * b;
            cost += Math.min((n % m) * a, b);
        } else {
            cost += n * a;
        }
        System.out.println(cost);
    }
}
