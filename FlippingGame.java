import java.util.*;
public class FlippingGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        int totalOnes = 0;
        for (int x : arr) if (x == 1) totalOnes++;
        int maxGain = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int gain = 0;
                for (int k = i; k <= j; k++) {
                    if (arr[k] == 0) gain++;
                    else gain--;
                }
                maxGain = Math.max(maxGain, gain);
            }
        }
        // If all are 1s, flipping any segment will reduce the count by 1
        int result = totalOnes + maxGain;
        if (result == totalOnes) result--;
        System.out.println(result);
    }
}
