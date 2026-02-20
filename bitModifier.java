import java.util.Scanner;

public class bitModifier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = 0;
        
        for (int i = 0; i < n; i++) {
            String statement = in.next();
            if (statement.contains("++")) {
                x++;
            } else if (statement.contains("--")) {
                x--;
            }
        }
        
        System.out.println(x);
    }
}
