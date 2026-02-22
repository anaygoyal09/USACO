import java.util.Scanner;
import java.util.Arrays;
public class SwapToWin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int repeat = in.nextInt();
        for(int i=0;i<repeat;i++)
        {
            int wordsNumber = in.nextInt();
            int letters = in.nextInt();
            in.nextLine();
            String[] wordsArray = new String[wordsNumber + 1];
            for(int a = 0; a <= wordsNumber; a++)
            {
                wordsArray[a] = in.nextLine();
            }
            System.out.println(Arrays.toString(wordsArray));
        }
        

    }
}
