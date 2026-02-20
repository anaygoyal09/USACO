import java.util.Scanner;

public class TheatreSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long a = in.nextLong();
        
        long countN = (n + a - 1) / a;
        long countM = (m + a - 1) / a;
        
        System.out.println(countN * countM);
    }
}
