public class ChipExchange {
    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            String[] parts = br.readLine().split(" ");
            long initialChipsA = Long.parseLong(parts[0]);
            long initialChipsB = Long.parseLong(parts[1]);
            long chipsPerExchangeA = Long.parseLong(parts[2]);
            long chipsPerExchangeB = Long.parseLong(parts[3]);
            long targetChipsA = Long.parseLong(parts[4]);
            long answer = solve(initialChipsA, initialChipsB, chipsPerExchangeA, chipsPerExchangeB, targetChipsA);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static long solve(long initialChipsA, long initialChipsB, long chipsPerExchangeA, long chipsPerExchangeB, long targetChipsA) {
        if (initialChipsA >= targetChipsA) return 0;
        long minimumChipsNeeded = Long.MAX_VALUE;
        long maxExchanges = (targetChipsA - initialChipsA) / chipsPerExchangeA;
        for (long exchanges = 0; exchanges <= maxExchanges; exchanges++) {
            long neededChipsA = targetChipsA - initialChipsA - exchanges * chipsPerExchangeA;
            long neededChipsB = exchanges * chipsPerExchangeB - initialChipsB;
            long totalChipsNeeded = Math.max(0, neededChipsA) + Math.max(0, neededChipsB);
            if (totalChipsNeeded < minimumChipsNeeded) minimumChipsNeeded = totalChipsNeeded;
        }
        return minimumChipsNeeded;
    }
}
