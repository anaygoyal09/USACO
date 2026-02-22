
import java.util.*;
public class SleepingInClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int i =0; i <n;i++)
        {
            int b = in.nextInt();
            int[] arr = new int[b];
            int total = 0;
            ArrayList<Integer> divisors = new ArrayList<>();
            for(int j =0; j < b; j++)
            {
                arr[j] = in.nextInt();
                total+=arr[j];
            }
            for(int j =1; j <= total; j++)
            {
                if(total%j == 0)
                {
                    divisors.add(j);
                }
            }
            int minOps = Integer.MAX_VALUE;
            for(int d : divisors) {
                int ops = 0;
                int curr = 0;
                boolean valid = true;
                for(int j = 0; j < b; j++) {
                    curr += arr[j];
                    if(curr > d) {
                        valid = false;
                        break;
                    } else if(curr == d) {
                        curr = 0;
                    } else {
                        ops++;
                    }
                }
                if(valid && curr == 0) {
                    minOps = Math.min(minOps, ops);
                }
            }
            if (minOps == Integer.MAX_VALUE) minOps = 0;
            System.out.println(minOps);
        }
    }
}
