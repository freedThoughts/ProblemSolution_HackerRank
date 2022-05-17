package hackerProblems2;

import java.util.List;

// https://www.hackerrank.com/challenges/the-grid-search/problem
public class TheGridSearch {
    public static String gridSearch(List<String> G, List<String> P) {

        for (int i = 0; i <= G.size()-P.size(); i++) {
            for (int j = 0; j <= G.get(0).length()-P.get(0).length(); j++) {
                if(G.get(i).substring(j, j+P.get(0).length()).equals(P.get(0)) ) {
                    int m = i+1;
                    int n = 1;
                    boolean found = true;
                    for(; n <P.size(); m++,n++) {
                        if(!G.get(m).substring(j, j+P.get(0).length()).equals(P.get(n))) {
                            found = false;
                            break;
                        }
                    }
                    if (found) return "YES";
                }
            }
        }
        return "NO";
    }
}
