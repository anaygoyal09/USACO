
import java.util.*;

public class ItsMooinTime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int threshold = in.nextInt();
        char[] chars = in.next().toCharArray();

        int[][] mooCount = new int[26][26];
        for (int i = 1; i <= n - 2; i++) {
            int first = chars[i - 1] - 'a';
            int second = chars[i] - 'a';
            int third = chars[i + 1] - 'a';
            if (second == third && first != second) {
                mooCount[first][second]++;
            }
        }

        Set<String> validMoos = new TreeSet<>();

        for (int first = 0; first < 26; first++) {
            for (int second = 0; second < 26; second++) {
                if (first != second && mooCount[first][second] >= threshold) {
                    validMoos.add("" + (char) ('a' + first) + (char) ('a' + second) + (char) ('a' + second));
                }
            }
        }

        int[] deltaFirst = new int[6], deltaSecond = new int[6], deltaDir = new int[6];
        for (int i = 0; i < n; i++) {
            for (int replacement = 0; replacement < 26; replacement++) {
                if (replacement == chars[i] - 'a') {
                    continue;
                }

                int deltaCount = 0;
                for (int j = Math.max(0, i - 2); j <= Math.min(n - 3, i); j++) {
                    int origFirst = chars[j] - 'a', origSecond = chars[j + 1] - 'a', origThird = chars[j + 2] - 'a';
                    if (origSecond == origThird && origFirst != origSecond) {
                        mooCount[origFirst][origSecond]--;
                        deltaFirst[deltaCount] = origFirst;
                        deltaSecond[deltaCount] = origSecond;
                        deltaDir[deltaCount] = -1;
                        deltaCount++;
                    }
                    int newFirst;
                    if (j == i) {
                        newFirst = replacement;
                    } else {
                        newFirst = origFirst;
                    }
                    int newSecond;
                    if (j + 1 == i) {
                        newSecond = replacement;
                    } else {
                        newSecond = origSecond;
                    }
                    int newThird;
                    if (j + 2 == i) {
                        newThird = replacement;
                    } else {
                        newThird = origThird;
                    }
                    if (newSecond == newThird && newFirst != newSecond) {
                        mooCount[newFirst][newSecond]++;
                        deltaFirst[deltaCount] = newFirst;
                        deltaSecond[deltaCount] = newSecond;
                        deltaDir[deltaCount] = 1;
                        deltaCount++;
                    }
                }

                for (int k = 0; k < deltaCount; k++) {
                    int first = deltaFirst[k], second = deltaSecond[k];
                    if (first != second && mooCount[first][second] >= threshold) {
                        validMoos.add("" + (char) ('a' + first) + (char) ('a' + second) + (char) ('a' + second));
                    }
                }

                for (int k = 0; k < deltaCount; k++) {
                    mooCount[deltaFirst[k]][deltaSecond[k]] -= deltaDir[k];
                }
            }
        }

        System.out.println(validMoos.size());
        for (String moo : validMoos) {
            System.out.println(moo);
        }
    }
}
