import java.util.*;

public class FarmerJohnActuallyFarms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            String t = sc.nextLine();
            char[][] s = new char[N][M];
            for (int i = 0; i < N; i++) {
                s[i] = sc.nextLine().toCharArray();
            }
            List<String> ops = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (s[0][i] == t.charAt(i)) continue;
                boolean found = false;
                // Try to swap with another string at same position
                for (int j = 1; j < N; j++) {
                    if (s[j][i] == t.charAt(i)) {
                        ops.add("2 1 " + (j+1) + " " + (i+1));
                        char tmp = s[0][i];
                        s[0][i] = s[j][i];
                        s[j][i] = tmp;
                        found = true;
                        break;
                    }
                }
                if (found) continue;
                // Try to swap within s1
                for (int p = 0; p < M; p++) {
                    if (s[0][p] == t.charAt(i) && s[0][p] != t.charAt(p)) {
                        ops.add("1 1 " + (i+1) + " " + (p+1));
                        char tmp = s[0][i];
                        s[0][i] = s[0][p];
                        s[0][p] = tmp;
                        found = true;
                        break;
                    }
                }
                if (found) continue;
                // Try to swap from another string at another position
                outer:
                for (int j = 1; j < N; j++) {
                    for (int p = 0; p < M; p++) {
                        if (s[j][p] == t.charAt(i)) {
                            ops.add("2 1 " + (j+1) + " " + (p+1));
                            char tmp = s[0][i];
                            s[0][i] = s[j][p];
                            s[j][p] = tmp;
                            ops.add("1 1 " + (i+1) + " " + (p+1));
                            char tmp2 = s[0][i];
                            s[0][i] = s[0][p];
                            s[0][p] = tmp2;
                            break outer;
                        }
                    }
                }
            }
            System.out.println(ops.size());
            for (String op : ops) {
                System.out.println(op);
            }
        }
    }
}