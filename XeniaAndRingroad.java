import java.util.Scanner;

public class XeniaAndRingroad {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		long time = 0L;
		int current = 1;

		for (int i = 0; i < m; i++) {
			int target = in.nextInt();
			if (target >= current) {
				time += target - current;
			} else {
				time += (n - current) + target;
			}
			current = target;
		}

		System.out.println(time);
	}
}
