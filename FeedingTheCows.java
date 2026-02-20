import java.util.*;

public class FeedingTheCows {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int test = 0; test < T; test++) {
			int N = in.nextInt();
			int K = in.nextInt();
			String cows = in.next();
			char[] res = new char[N];
			Arrays.fill(res, '.');
			int patches = 0;
			int i = 0;
			while (i < N) {
				if (res[i] != '.') { i++; continue; }
				char breed = cows.charAt(i);
				int patchPos = Math.min(N - 1, i + K);  
				// Place patch as far right as possible for this breed
				for (int j = patchPos; j >= i; j--) {
					if (cows.charAt(j) == breed) {
						patchPos = j;
						break;
					}
				}
				res[patchPos] = breed;
				patches++;
				i = patchPos + K + 1;
			}
			System.out.println(patches);
			System.out.println(new String(res));
		}
	}
}
