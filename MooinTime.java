
import java.io.*;
import java.util.*;

public class MooinTime {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

		// For each value, store all positions
		Map<Integer, ArrayList<Integer>> pos = new HashMap<>();
		for (int i = 0; i < N; i++) {
			pos.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i);
		}

		// For each value, store the first occurrence
		Map<Integer, Integer> firstOccur = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!firstOccur.containsKey(a[i])) firstOccur.put(a[i], i);
		}

		Set<Long> moos = new HashSet<>(); // Use long to encode (x, y)
		for (int y : pos.keySet()) {
			ArrayList<Integer> yPos = pos.get(y);
			if (yPos.size() < 2) continue;
			// For all x ≠ y
			for (int x : pos.keySet()) {
				if (x == y) continue;
				int fx = firstOccur.get(x);
				// If x appears before any y after the first
				for (int k = 1; k < yPos.size(); k++) {
					if (fx < yPos.get(k)) {
						moos.add(((long)x << 32) | (long)y);
						break;
					}
				}
			}
		}
		System.out.println(moos.size());
	}
}
