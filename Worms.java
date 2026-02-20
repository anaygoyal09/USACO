import java.util.Scanner;
public class Worms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] piles = new int[num];
        int currentTotal=0;
        for(int i = 0; i < num; i++)
        {
            piles[i] = in.nextInt() + currentTotal;
            currentTotal += piles[i] - currentTotal;
        }
        int juicy = in.nextInt();
        for (int i = 0; i < juicy; i++) {
            int q = in.nextInt();
            int l = 0, r = num - 1, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (piles[mid] >= q) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println(ans + 1);
        }
    }
}
