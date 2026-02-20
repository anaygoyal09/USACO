import java.util.Scanner;
public class Expression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int max = a + b + c;
        max = Math.max(max, a * b * c);
        max = Math.max(max, (a + b) * c);
        max = Math.max(max, a * (b + c));
        max = Math.max(max, a + b * c);
        max = Math.max(max, a * b + c);
        System.out.println(max);
    }
}
