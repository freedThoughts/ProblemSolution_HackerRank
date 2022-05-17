package hackerProblems2;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int count = 0;
        int level = 0;
        for (char c : path.toCharArray()) {
            if (c == 'D') level--;
            else {
                level++;
                if (level == 0) count++;
            }
        }
        return count;
    }


}
