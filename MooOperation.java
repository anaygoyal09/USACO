
import java.util.Scanner;

public class MooOperation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        in.nextLine();
        for (int q = 0; q < Q; q++) {
            String s = in.nextLine();
            int n = s.length();
            int min = Integer.MAX_VALUE;
            if (n < 3) {
                System.out.println(-1);
                continue;
            }
            for (int i = 0; i <= n - 3; i++) {
                String sub = s.substring(i, i + 3);
                int rep = 0;
                if (sub.charAt(0) != 'M') {
                    rep++;
                }
                if (sub.charAt(1) != 'O') {
                    rep++;
                }
                if (sub.charAt(2) != 'O') {
                    rep++;
                }
                int del = i + (n - (i + 3));
                min = Math.min(min, del + rep);
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min);
            }
        }
    }
}
