package warmUpPackage1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
	
	public static void fractionPrint(int N, int[] arr){
		
		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;
		
		for(int i = 0; i<N; i++){
			if(arr[i]>0) positiveCount++;
			if(arr[i]<0) negativeCount++;
			if(arr[i]==0) zeroCount++;
		}
		
		//DecimalFormat numberFormat = new DecimalFormat("##.000000");

		System.out.println(String.format("%.6f", (double)positiveCount/N));
		System.out.println(String.format("%.6f", (double)negativeCount/N));
		System.out.println(String.format("%.6f", (double)zeroCount/N));
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        fractionPrint(n, arr);
    }
}


/*

Given an array of integers, calculate which fraction of its elements are positive, which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively. Print the decimal value of each fraction on a new line.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.

Input Format

The first line contains an integer, , denoting the size of the array. 
The second line contains  space-separated integers describing an array of numbers .

Output Format

You must print the following  lines:

A decimal representing of the fraction of positive numbers in the array compared to its size.
A decimal representing of the fraction of negative numbers in the array compared to its size.
A decimal representing of the fraction of zeroes in the array compared to its size.
Sample Input

6
-4 3 -9 0 4 1         
Sample Output

0.500000
0.333333
0.166667
Explanation

There are  positive numbers,  negative numbers, and  zero in the array. 
The respective fractions of positive numbers, negative numbers and zeroes are ,  and , respectively.

*/