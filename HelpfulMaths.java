import java.util.*;
public class HelpfulMaths {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < s.length(); i += 2) {
			nums.add(s.charAt(i) - '0');
		}
		Collections.sort(nums);
		for (int i = 0; i < nums.size(); i++) {
			if (i > 0) System.out.print("+");
			System.out.print(nums.get(i));
		}
	}
}
