
import java.util.Scanner;

public class ChatRoom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int start = 0;
        if (s.indexOf("h") != -1) {
            start = s.indexOf("h");
        }
        if (start != -1 && s.indexOf("e", start) != -1) {
            start = s.indexOf("e", start+1);
        }
        else {
            start = -1;
        }
        if (start != -1 && s.indexOf("l", start) != -1) {
            start = s.indexOf("l", start+1);
        }
        else {
            start = -1;
        }
        if (start != -1 && s.indexOf("l", start) != -1) {
            start = s.indexOf("l", start+1);
        }
        else {
            start = -1;
        }
        if (start != -1 && s.indexOf("o", start) != -1) {
            start = s.indexOf("o", start+1);
        }
        else {
            start = -1;
        }
        if (start != -1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
