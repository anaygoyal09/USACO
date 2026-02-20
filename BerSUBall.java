import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class BerSUBall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numBoys = in.nextInt();
        ArrayList<Integer> boysSkills = new ArrayList<>();
        for(int boyIndex = 0; boyIndex < numBoys; boyIndex++) {
            boysSkills.add(in.nextInt());
        }
        Collections.sort(boysSkills);
        int numGirls = in.nextInt();
        ArrayList<Integer> girlsSkills = new ArrayList<>();
        for(int girlIndex = 0; girlIndex < numGirls; girlIndex++) {
            girlsSkills.add(in.nextInt());
        }
        Collections.sort(girlsSkills);
        int boyPointer = 0, girlPointer = 0, maxPairs = 0;
        while (boyPointer < boysSkills.size() && girlPointer < girlsSkills.size()) {
            int boySkill = boysSkills.get(boyPointer);
            int girlSkill = girlsSkills.get(girlPointer);
            if (Math.abs(boySkill - girlSkill) <= 1) {
                maxPairs++;
                boyPointer++;
                girlPointer++;
            } else if (boySkill < girlSkill) {
                boyPointer++;
            } else {
                girlPointer++;
            }
        }
        System.out.println(maxPairs);
    }
}
