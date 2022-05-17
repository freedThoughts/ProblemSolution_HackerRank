package hackerProblems2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CutTheTree {

    public static void main(String[] arg) {

        List<Integer> data = Arrays.asList(100, 200, 100, 500, 100, 600);
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(2, 5), Arrays.asList(4, 5) ,Arrays.asList(5, 6));
        System.out.println(cutTheTree(data, edges));
    }

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            List<Integer> list = map.get(edge.get(0));
            if (list == null) list = new ArrayList<>();
            list.add(edge.get(1));
            map.put(edge.get(0), list);
        }

        Map<Integer, Integer> sumMap = new HashMap<>();
        fillMap(1, map, sumMap, data);
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getKey() == 1) continue;
            int m = entry.getValue();
            min = Math.min(min, sumMap.get(1) > m ? sumMap.get(1) - m : m - sumMap.get(1));
        }

        return min;



    }

    static int fillMap(Integer node, Map<Integer, List<Integer>> map, Map<Integer, Integer> sumMap, List<Integer> data) {

        if (sumMap.containsKey(node)) return sumMap.get(node);
        int sum = data.get(node-1);
        if (map.get(node) == null) {
            sumMap.put(node, sum);
            return sum;
        }
        for (Integer i : map.get(node)) {
            sum += fillMap(i, map, sumMap, data);
        }
        sumMap.put(node, sum);
        return sum;
    }
}
