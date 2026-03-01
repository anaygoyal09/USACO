
import java.util.Scanner;

public class CutRibbon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        //test for 3 nums
        if (num == a + b + c) {
            System.out.println(3);
            return;
        }

        //test for 2 nums
        if (num == a + b || num == a + c || num == b + c) {
            System.out.println(2);
            return;
        }
        //test for 1 num
        if (num == a || num == b || num == c) {
            System.out.println(1);
            return;
        }

    }
}
