import java.util.*;

public class Laptops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] laptops = new int[n][2];
        for (int i = 0; i < n; i++) {
            laptops[i][0] = sc.nextInt(); // price
            laptops[i][1] = sc.nextInt(); // quality
        }
        Arrays.sort(laptops, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < n; i++) {
            if (laptops[i][1] < laptops[i - 1][1]) {
                System.out.println("Happy Alex");
                return;
            }
        }
        System.out.println("Poor Alex");
    }
}