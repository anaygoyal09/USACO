import java.util.*;

public class CheeseBlockQuestion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int Q = in.nextInt();

        // xCount[y][z]: how many cells along x have been carved in line (y,z)
        // yCount[x][z]: how many cells along y have been carved in line (x,z)
        // zCount[x][y]: how many cells along z have been carved in line (x,y)
        int[][] xCount = new int[N][N];
        int[][] yCount = new int[N][N];
        int[][] zCount = new int[N][N];

        long xAns = 0, yAns = 0, zAns = 0;

        for (int q = 0; q < Q; q++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();

            if (++xCount[y][z] == N) xAns++;
            if (++yCount[x][z] == N) yAns++;
            if (++zCount[x][y] == N) zAns++;

            System.out.println(xAns + yAns + zAns);
        }
    }
}
