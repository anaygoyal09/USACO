import java.util.*;

public class CowSplits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int k = sc.nextInt();
		for (int test = 0; test < T; test++) {
			int N = sc.nextInt();
			String S = sc.next();
			int len = 3 * N;
			// Check if S can be split into N blocks of 3, each a cyclic shift of "COW"
			String[] blocks = new String[N];
			for (int i = 0; i < N; i++) {
				blocks[i] = S.substring(3 * i, 3 * i + 3);
				if (!isCOWCyclic(blocks[i])) {
					System.out.println("-1");
					continue;
				}
			}
			// Try to greedily remove pairs of blocks as square strings
			// Since all blocks are cyclic shifts, any two identical blocks can form a square string
			Map<String, List<Integer>> blockIndices = new HashMap<>();
			for (int i = 0; i < N; i++) {
				blockIndices.computeIfAbsent(blocks[i], x -> new ArrayList<>()).add(i);
			}
			List<int[]> pairs = new ArrayList<>();
			boolean[] used = new boolean[N];
			for (String key : blockIndices.keySet()) {
				List<Integer> idxs = blockIndices.get(key);
				for (int i = 0; i + 1 < idxs.size(); i += 2) {
					pairs.add(new int[]{idxs.get(i), idxs.get(i + 1)});
					used[idxs.get(i)] = true;
					used[idxs.get(i + 1)] = true;
				}
			}
			int left = 0;
			for (int i = 0; i < N; i++) if (!used[i]) left++;
			if (left % 2 != 0) {
				System.out.println("-1");
				continue;
			}
			int M = pairs.size() + left / 2;
			if (k == 1 && M < N) M = N; // allow one extra operation
			System.out.println(M);
			int[] op = new int[len];
			int opNum = 1;
			// Assign operations for pairs
			for (int[] p : pairs) {
				for (int j = 0; j < 3; j++) op[3 * p[0] + j] = opNum;
				for (int j = 0; j < 3; j++) op[3 * p[1] + j] = opNum;
				opNum++;
			}
			// Assign operations for remaining blocks
			List<Integer> rem = new ArrayList<>();
			for (int i = 0; i < N; i++) if (!used[i]) rem.add(i);
			for (int i = 0; i < rem.size(); i += 2) {
				for (int j = 0; j < 3; j++) op[3 * rem.get(i) + j] = opNum;
				for (int j = 0; j < 3; j++) op[3 * rem.get(i + 1) + j] = opNum;
				opNum++;
			}
			for (int i = 0; i < len; i++) {
				System.out.print(op[i]);
				if (i < len - 1) System.out.print(" ");
			}
			System.out.println();
		}
	}

	static boolean isCOWCyclic(String s) {
		return s.equals("COW") || s.equals("OWC") || s.equals("WCO");
	}
}
