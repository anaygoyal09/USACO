import java.util.Scanner;
public class PetyaandStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int ans = 0;
        if(s1.compareTo(s2) < 0)
        {
            ans = -1;
        }
        else if (s1.compareTo(s2) > 0)
        {
            ans = 1;
        }
        System.out.println(ans);
        
        
    }
}
