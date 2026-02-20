import java.util.Scanner;

public class BoyorGirl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        boolean[] seen = new boolean[26];
        int distinct = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            int idx = c - 'a';
            if (!seen[idx]) {
                seen[idx] = true;
                distinct++;
            }
        }
        if (distinct % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
