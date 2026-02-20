import java.util.*;
public class CowCollege {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        Arrays.sort(c);
        long maxMoney = 0;
        int bestTuition = 0;
        for (int i = 0; i < n; i++) {
            long money = (long) c[i] * (n - i);
            if (money > maxMoney || (money == maxMoney && c[i] < bestTuition)) {
                maxMoney = money;
                bestTuition = c[i];
            }
        }
        System.out.println(maxMoney + " " + bestTuition);
    }
}
