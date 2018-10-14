package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class MigratoryBirds2 {
	
	static int migratoryBirds(int n, int[] ar) {
		
		Arrays.sort(ar);

/*		int resultType = 0;
		int resultCount = 0;
		
		int tempType = 0;
		int tempTypeCount = 0;
		
		
		for(int i = 0; i<n; i++){
			if(i == 0 || ar[i] > ar[i-1]){
				if(tempTypeCount > resultCount){
					resultType = tempType;
					resultCount = tempTypeCount;
				}
				tempType = i;
				tempTypeCount = 1;
			}
			else {
				tempTypeCount ++;
			}
		}
		
		return tempTypeCount > resultCount ? ar[tempType] : ar[resultType];*/
		
		int currentBirdType = ar[0];
		int currentBirdCount = 0;
		int mostFrequentBirdType = ar[0];
		int mostFrequentBirdCount = 0;
		for(int i = 0; i<n; i++){
			currentBirdType = ar[i];
			if(i>0 && ar[i] == ar[i-1]){
				currentBirdCount ++;
				if(currentBirdCount > mostFrequentBirdCount){
					mostFrequentBirdCount = currentBirdCount;
					mostFrequentBirdType = currentBirdType;
				}
			}
			else {
				currentBirdCount = 1;
			}
		}
		
		return mostFrequentBirdType;
		
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
