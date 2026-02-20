/*
Farmer John has N cows in a line (1≤N≤3⋅10^5). Unfortunately, there is a sickness spreading throughout.

Initially, some cows start off infected. Every night, an infected cow spreads the sickness to the cows on their left and right (if they exist). Once a cow is infected, she stays infected.

After some amount of nights, Farmer John realizes that the issue has gotten out of control, so he tests his cows to determine who has the sickness. Find the minimum number of cows that could have started with the sickness.

INPUT FORMAT (input arrives from the terminal / stdin):

The first line contains N, the number of cows that Farmer John has.
The next line contains an N character bitstring of only 1s and 0s where a 1 represents an infected cow and a 0 represents an uninfected cow after some number of nights.

OUTPUT FORMAT (print output to the terminal / stdout):

Output a single integer: the minimum number of cows that could have started with the sickness.
SAMPLE INPUT:

5
11111
SAMPLE OUTPUT:

1
Suppose the middle cow was the only cow to start off infected. Then the cows would be infected in the following order:

0 nights:    00100 (the third cow is initially infected)
1 night:  -> 01110 (the second and fourth cows are now infected)
2 nights: -> 11111 (the first and fifth cows are now infected)
3 nights: -> 11111 (all cows already were infected, so no additional cows are infected)
          -> ...
After two or more nights, the final state of the cows would look like the input. There are many other initial states and number of nights that could have produced the input state, such as:

0 nights:    10001
1 night:  -> 11011
2 nights: -> 11111
or:

0 nights:    01001
1 night:  -> 11111
or:

0 nights:    01000
1 night:  -> 11100
2 nights: -> 11110
3 nights: -> 11111
All of these initial states contain at least one infected cow.

SAMPLE INPUT:

6
011101
SAMPLE OUTPUT:

4
The only initial state and number of nights that could have led to this final state is if no nights have passed and each of the four infected cows in the input started off with the sickness.

SCORING:

Inputs 3-7: N≤1000
Inputs 8-12: No additional constraints.
Problem credits: Suhas Nagar
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Cowntact {

    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    String s = in.next();

    public static void main(String[] args) {
        Cowntact c = new Cowntact();
        c.solve();
    }

    public void solve() {
        ArrayList<Integer> infected = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {

            if (count > 0 && s.charAt(i) == '0') {
                infected.add(count);
                count=0;
            }
            else if (s.charAt(i) == '1') {
                count++;
            }
        }
        if(count>0){
            infected.add(count);
        }   
        infected.remove(0);
        System.out.println(infected.toString());

        int ans = 0;
        for (int i = 0; i < infected.size(); i++) {
            if (infected.get(i) > 0) {
                ans++;
                infected.set(i, infected.get(i) - 1);
                
    }
}
