package warmUpPackage1;

import java.util.Scanner;

public class BirthdayCakeCandles {
	
    static int birthdayCakeCandles(int n, int[] ar) {
    	int maxValue = 0;
    	int maxCount = 0;
    	for(int i = 0; i< ar.length; i++){
    		if (maxValue == ar[i]) maxCount++;
    		if (maxValue < ar[i]){
    			maxValue = ar[i];
    			maxCount = 1;
    		}
    	}
    	
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

}
