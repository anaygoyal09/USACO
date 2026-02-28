import java.util.Scanner;
public class FancyFence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i =0; i<n; i++)
        {
            int angle = in.nextInt();
            if (angle < 180 && 360 % (180 - angle) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
