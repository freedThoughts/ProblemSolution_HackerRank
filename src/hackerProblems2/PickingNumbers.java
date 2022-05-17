package hackerProblems2;

import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/challenges/picking-numbers/problem
public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int ans = 0;
        int start = 0;

        for (int i = 1; i < a.size(); i++) {
            while(a.get(i) - a.get(start) > 1) {
                ans = Math.max(ans, i-start);
                start++;
            }
        }
        ans = Math.max(ans, a.size() - start);
        return ans;
    }
}
