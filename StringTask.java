import java.util.Scanner;
public class StringTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c != 'a' && c != 'o' && c != 'y' && c != 'e' && c != 'u' && c != 'i') {
                result += "." + c;
            }
        }
        System.out.println(result);
    }
}
