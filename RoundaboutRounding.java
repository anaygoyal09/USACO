
import java.util.*;

public class RoundaboutRounding {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        int[] queries = new int[testCases];
        int maxValue = 0;
        for (int i = 0; i < testCases; i++) {
            queries[i] = in.nextInt();
            maxValue = Math.max(maxValue, queries[i]);
        }
        int[] prefixCount = new int[maxValue + 1];
        for (int x = 2; x <= maxValue; x++) {
            int numDigits = (int) Math.ceil(Math.log10(x));
            // Normal rounding
            int roundPow = (int) Math.round(Math.pow(10, numDigits));
            int prevRoundPow = (int) Math.round(Math.pow(10, numDigits - 1));
            int leadingDigit = (x / prevRoundPow) % 10;
            int rounded = x;
            if (leadingDigit >= 5) {
                rounded += roundPow;
            }
            rounded = (rounded / roundPow) * roundPow;

            // Chain rounding
            int chainResult = x;
            for (int place = 1; place <= numDigits; place++) {
                int currentPow = (int) Math.round(Math.pow(10, place));
                int prevPow = (int) Math.round(Math.pow(10, place - 1));
                int currentDigit = (chainResult / prevPow) % 10;
                if (currentDigit >= 5) {
                    chainResult += currentPow;
                }
                chainResult = (chainResult / currentPow) * currentPow;
            }

            if (rounded != chainResult) {
                prefixCount[x] = prefixCount[x - 1] + 1;
            } else {
                prefixCount[x] = prefixCount[x - 1];
            }
        }

        for (int i = 0; i < testCases; i++) {
            if (queries[i] >= 2) {
                System.out.println(prefixCount[queries[i]]);
            } else {
                System.out.println(0);
            }
        }
    }

}
