import java.util.Scanner;
public class CapsLock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        boolean allUpper = true;
        boolean exceptFirstUpper = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isUpperCase(str.charAt(i))) {
                allUpper = false;
            }
        }
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isUpperCase(str.charAt(i))) {
                exceptFirstUpper = false;
            }
        }
        if (allUpper) {
            System.out.println(str.toLowerCase());
        } else if (exceptFirstUpper) {
            char first = Character.toUpperCase(str.charAt(0));
            String rest = str.substring(1).toLowerCase();
            System.out.println(first + rest);
        } else {
            System.out.println(str);
        }
    }
}
