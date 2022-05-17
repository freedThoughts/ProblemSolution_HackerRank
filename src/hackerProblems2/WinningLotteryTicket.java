package hackerProblems2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotteryTicket {

    public static long winningLotteryTicket(List<String> tickets) {

        List<Set<Character>> lists = new ArrayList<>();
        for(int i = 0; i < tickets.size(); i++) {
            Set<Character> set = new HashSet<>();
            for(char c : tickets.get(i).toCharArray())
                set.add((c));
            lists.add(set);
        }

        int count = 0;
        for(int i = 0; i < lists.size(); i++) {
            for(int j = i+1; j < lists.size(); j++) {
                Set<Character> set = new HashSet<>();
                set.addAll(lists.get(i));
                set.addAll(lists.get(j));
                if(set.size() == 10) count++;

            }
        }
        return count;

    }
}
