package hackerProblems2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/climbing-the-leaderboard
public class ClimbingTheLeaderboard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        bufferedReader.close();
        //bufferedWriter.close();

        List<Integer> result = climbingLeaderboard(ranked, player);
        System.out.println(result);
    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> results = new ArrayList<>();
        List<Integer> revRanked = new ArrayList<>();
        revRanked.add(ranked.get(0));
        for(int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(revRanked.get(revRanked.size()-1)) ) revRanked.add(ranked.get(i));
        }

        int i = revRanked.size()-1;
        int j = 0;
        while(i >= 0 && j < player.size()) {
            while(i >= 0 && player.get(j) > revRanked.get(i)) i--;
            if (i < 0) break;
            if(player.get(j).equals(revRanked.get(i))) results.add(i+1);
            else results.add(i+2);
            j++;
        }

        while(j < player.size()) {
            results.add(1);
            j++;
        }
        return results;
    }
}


