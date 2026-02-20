
import java.util.Scanner;

public class Dragons {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int startH = in.nextInt();
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            int DragHealth = in.nextInt();
            int bonus = in.nextInt();
            if (startH > DragHealth) {
                startH += bonus;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
