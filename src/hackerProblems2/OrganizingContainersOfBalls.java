package hackerProblems2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class OrganizingContainersOfBalls {

    public static String organizingContainers(List<List<Integer>> container) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < container.size(); i++) {
            int sum = 0;
            for (int j =0; j < container.get(0).size(); j++)
                sum += container.get(i).get(j);
            Integer val = map.get(sum);
            if (val == null) map.put(sum, 1);
            else map.put(sum, 1+ val);
        }

        int[] arr = new int[container.get(0).size()];
        for(int i = 0; i < container.size(); i++) {
            for (int j = 0; j < container.get(0).size(); j++) {
                arr[j]  += container.get(i).get(j);
            }
        }

        for(int i : arr){
            Integer val = map.get(i);
            if (val == null) return "Impossible";
            if (val > 1) map.put(i, val-1);
            else map.remove(i);
        }

        if (map.size() > 0) return "Impossible";
        return "Possible";
    }
}
