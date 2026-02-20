import java.util.Scanner;
public class Taxi { 
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] count = new int[5];
        for (int i = 0; i < N; i++) {
            int size = in.nextInt();
            count[size]++;
        }

        int taxis = 0;

        taxis += count[4];

        int pair13 = Math.min(count[1], count[3]);
        taxis += pair13;
        count[1] -= pair13;
        count[3] -= pair13;

        taxis += count[3];

        taxis += count[2] / 2;
        count[2] %= 2;

        if (count[2] == 1) {
            taxis += 1;
            count[1] = Math.max(0, count[1] - 2);
        }

        if (count[1] > 0) {
            taxis += (count[1] + 3) / 4;
        }

        System.out.println(taxis);
    }
    
}
