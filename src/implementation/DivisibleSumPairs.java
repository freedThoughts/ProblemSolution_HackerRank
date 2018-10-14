package implementation;

import java.util.Scanner;

public class DivisibleSumPairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
    	
    	int resultCount = 0;
    	
        for(int j = 1; j<n; j++){
        	for(int i = j-1; i>=0; i--){
        		if((ar[i]+ar[j]) % k == 0) resultCount ++;
        	}
        }
    	
    	return resultCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}
