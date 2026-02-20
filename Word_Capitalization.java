import java.util.Scanner;
public class Word_Capitalization {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
    }
}
