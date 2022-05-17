package hackerProblems2;

import java.util.ArrayList;
import java.util.List;

public class BomberMan {

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n%4 == 1) return grid;

        List<String> results = new ArrayList<>();
        if (n%2 == 0) {
            StringBuffer sb = new StringBuffer();
            for(int i =0; i < grid.get(0).length(); i++)
                sb.append("0");
            String full = new String(sb);

            for (int i = 0; i < grid.size(); i++) {
                results.add(full);
            }

            return results;
        }


        for(int i = 0; i < grid.size(); i++) {
            String str = grid.get(i);
            char[] arr = new char[str.length()];
            for(int j = 0; j < arr.length; j++) {
                if (str.charAt(j) == '0' ||
                        (j < arr.length-1 && str.charAt(j+1) == '0' )||
                        (j > 0 && str.charAt(j-1) == '0' ) ||
                        ( i > 0 && grid.get(i-1).charAt(j) == '0' ) ||
                        (i < grid.size()-1 && grid.get(i+1).charAt(j) == '0') ) {
                    arr[j] = '.';
                } else arr[j] = '0';
            }
            results.add(new String(arr));
        }

        return results;
    }

}
