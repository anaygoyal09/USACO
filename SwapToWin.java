import java.util.Arrays;
import java.util.Scanner;
public class SwapToWin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int ti = 0; ti < T; ti++) {
            int N = in.nextInt();
            int M = in.nextInt();
            in.nextLine(); // consume newline
            String t = in.nextLine().trim();
            char[][] s = new char[N][M];
            for(int i = 0; i < N; i++) {
                String line = in.nextLine().trim();
                while(line.length() < M) {
                    String extra = in.nextLine();
                    if(extra == null) break;
                    line = extra.trim();
                }
                s[i] = line.toCharArray();
            }

            java.util.List<String> ops = new java.util.ArrayList<>();

            for(int pos = 0; pos < M; pos++) {
                if(s[0][pos] == t.charAt(pos)) continue;
                boolean done = false;
                for(int j = pos+1; j < M && !done; j++) {
                    if(s[0][j] == t.charAt(pos)) {
                        swapInString(s[0], pos, j);
                        ops.add(String.format("1 1 %d %d", pos+1, j+1));
                        done = true;
                    }
                }
                if(done) continue;
                for(int k = 1; k < N && !done; k++) {
                    if(s[k][pos] == t.charAt(pos)) {
                        char tmp = s[0][pos];
                        s[0][pos] = s[k][pos];
                        s[k][pos] = tmp;
                        ops.add(String.format("2 1 %d %d", k+1, pos+1));
                        done = true;
                    }
                }
                if(done) continue;
                for(int k = 1; k < N && !done; k++) {
                    for(int j = 0; j < M && !done; j++) {
                        if(s[k][j] == t.charAt(pos)) {
                            if(j != pos) {
                                swapInString(s[k], j, pos);
                                ops.add(String.format("1 %d %d %d", k+1, j+1, pos+1));
                            }
                            char tmp = s[0][pos];
                            s[0][pos] = s[k][pos];
                            s[k][pos] = tmp;
                            ops.add(String.format("2 1 %d %d", k+1, pos+1));
                            done = true;
                        }
                    }
                }
            }

            if(ops.size() > 2 * M) {
                System.err.println("WARNING: ops exceed 2M: " + ops.size());
            }
            System.out.println(ops.size());
            for(String op : ops) {
                System.out.println(op);
            }
        }
    }

    private static void swapInString(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
