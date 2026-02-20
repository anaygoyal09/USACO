
import java.util.Scanner;

public class ReverseEngineering {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int test = 0; test < T; test++) {
            int N = in.nextInt();
            int M = in.nextInt();
            boolean lie = false;
            String[] inputs = new String[M];
            char[] outputs = new char[M];
            for (int i = 0; i < M; i++) {
                inputs[i] = in.next();
                outputs[i] = in.next().charAt(0);
            }
            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {
                    if (inputs[i].equals(inputs[j]) && outputs[i] != outputs[j]) {
                        lie = true;
                    }
                }
            }
            if (lie) {
                System.out.println("LIE");
            } else {
                System.out.println("OK");
            }
        }
    }
}
