import java.util.Scanner;
public class IQtest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int evenCount = 0, oddCount = 0;
        for(int num : nums) {
            if(num % 2 == 0) evenCount++;
            else oddCount++;
        }
        boolean majorityEven = evenCount > oddCount;
        for(int i = 0; i < n; i++) {
            boolean isEven = nums[i] % 2 == 0;
            if(isEven != majorityEven) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
