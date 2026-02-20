import java.util.*;

public class Leaders {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String breeds = in.next();
		int[] E = new int[N];
		for (int i = 0; i < N; i++) {
			E[i] = in.nextInt();
		}
		List<Integer> guernseys = new ArrayList<>();
		List<Integer> holsteins = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (breeds.charAt(i) == 'G') guernseys.add(i);
			else holsteins.add(i);
		}
		int count = 0;
		for (int g : guernseys) {
			for (int h : holsteins) {
				if (isValidLeaderPair(g, h, breeds, E, guernseys, holsteins)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	static boolean isValidLeaderPair(int g, int h, String breeds, int[] E, List<Integer> guernseys, List<Integer> holsteins) {
		// g is Guernsey leader, h is Holstein leader
		// Each leader's list must contain all their breed or the other leader
		boolean gList = true;
		for (int idx : guernseys) {
			if (E[g] < idx + 1) gList = false;
		}
		if (!gList && E[g] < h + 1) return false;
		boolean hList = true;
		for (int idx : holsteins) {
			if (E[h] < idx + 1) hList = false;
		}
		if (!hList && E[h] < g + 1) return false;
		return true;
	}
}
