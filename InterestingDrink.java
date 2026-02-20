import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        
        Arrays.sort(prices);
        
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int money = in.nextInt();
            int count = binarySearch(prices, money);
            System.out.println(count);
        }
    }
    
    private static int binarySearch(int[] prices, int money) {
        int left = 0, right = prices.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prices[mid] <= money) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
