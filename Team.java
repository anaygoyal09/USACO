
import java.util.Scanner;

public class Team {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int counter = 0;
        
        for (int i = 0; i < num; i++) {
            int petya = in.nextInt();
            int vasya = in.nextInt();
            int tonya = in.nextInt();
            
            int sum = petya + vasya + tonya;
            if (sum >= 2) {
                counter++;
            }
        }
        
        System.out.println(counter);
    }
}
