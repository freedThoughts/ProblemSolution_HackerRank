package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingTheLeaderboard {
	
	public static int[] getRank2(int[] scores, int[] alice){
		int[] result = new int[alice.length];
		
		if(scores.length == 0){
			for(int i =0; i<alice.length; i++)
				result[i] = 1;
			return result;
		}
		
		
		int j = alice.length-1;
		int currentRank = 0;
		
		for(int i = 0; i< scores.length && j>=0 && alice[j] != 0;){
			if((i != 0 && scores[i] == scores[i-1]) || scores[i] == 0){
				i++;
				continue;
			}
			
			if(alice[j] > scores[i]){
				currentRank ++;
				result[j] = currentRank;
				j--;
			}
			else if(alice[j] == scores[i]){
				currentRank ++;
				result[j] = currentRank;
				j--;
				i++;
			}
			else if(alice[j] < scores[i] && alice[j] != 0){
				//currentRank ++;
				i++;
			}
			
		}
		if(j>=0 && alice[j] < alice[j+1]) currentRank ++;
		for(; j>=0; j--){
			result[j] = currentRank;
		}
		
		//if(j>0 && alice[j] == alice[j-1]) currentRank--;
/*		int previousRank = currentRank -1;
		for(;j>=0; j--){
			if(alice[j] <alice[j+1]){
				result[j] =  currentRank;
			}
			else if(alice[j] == alice[j+1]){
				result[j] = previousRank;
			}
		}*/

		return result;
	}
	
	public static int[] getRank(int[] scores, int[] alice){
		
		int[] aliceRank = new int[alice.length];
		int j = alice.length - 1;
		int currentRank = 0;
		for(int i = scores.length-1; i>=0 && j>=0 ; ){
			if(i != scores.length-1 && scores[i] == scores[i+1]){
				i--;
				continue;
			}

			if(alice[j] > scores[i]){
				aliceRank[j] = currentRank+1;
				j--;
			}
			else if(alice[j] == scores[i]){
				currentRank ++;
				aliceRank[j] = currentRank;
				i--;
				j--;
			}
			else {
				currentRank ++;
				i--;
			}
		}
		
		if(j>=0) currentRank ++;
		for(; j>=0; j--){
			aliceRank[j] = currentRank;
		}
		
		return aliceRank;
		
/*		
		// Try latter
		int[] aliceRanks = new int[alice.length];
		int currentRank = 1;
		int temp = scores.length-1;
		for(int j = alice.length-1; j>=0; j--){
			for(; temp>=0; ){
				if(temp < scores.length-1 && scores[temp] == scores[temp+1])
					continue;
				if(alice[j] >= scores[temp])
					aliceRanks[j] = currentRank;
				else
					currentRank ++;
				
				
				temp ++;
			}

		}*/
		
/*		for(int i = scores.length-1; i>=0; i--){
			if(i != scores.length-1 && scores[i] == scores[i+1])
				continue;
			
			currentRank++;
			if(myScore >= scores[i]) return currentRank;
		}
		
		return currentRank+1;*/
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        // your code goes here
        in.close();
        //Arrays.sort(scores);
        if(alice.length == 0) return;
        
        int[] result = getRank2(scores, alice);
        for(int i = 0; i<result.length; i++)
        	System.out.println(result[i]);

    }
}
