public class PrintingSequences {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] seen = new boolean[K+1];
			int uniqueCount = 0;
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				if (!seen[x]) {
					seen[x] = true;
					uniqueCount++;
				}
			}
			if (uniqueCount <= K) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
