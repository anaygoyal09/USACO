import java.util.Scanner;

public class LuckyDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // All lucky numbers up to 1000 (numbers containing only digits 4 and 7)
        int[] lucky = {4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777};
        
        boolean isAlmostLucky = false;
        for (int num : lucky) {
            if (n % num == 0) {
                isAlmostLucky = true;
                break;
            }
        }
        
        if (isAlmostLucky) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
