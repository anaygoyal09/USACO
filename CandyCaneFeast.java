
/*

 */
import java.util.Scanner;

public class CandyCaneFeast {

    public static void main(String[] args) {
        feast();
    }

    public static void feast() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[] HeightsCows = new int[N];
        int[] HeightCandy = new int[M];

        for (int i = 0; i < N; i++) {
            HeightsCows[i] = in.nextInt();
        }
        for (int j = 0; j < M; j++) {
            HeightCandy[j] = in.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int candyEaten = 0;
            int candyBottom = 0;
            for (int a = 0; a < N; a++) {
               if(HeightsCows[a] >= candyBottom){
                  int amountEaten = Math.min(HeightsCows[a], HeightCandy[i]) - candyBottom;
                  HeightsCows[a] += amountEaten;
                  candyBottom += amountEaten;
               }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(HeightsCows[i]);
        }
    }
}
