package implementation;

import java.util.Scanner;

public class ElectronicsShop {
	
    static int getMoneySpent(int[] keyboards, int[] drives, int s){
    	
    	int moneySpent = 0;
    	for(int i = 0; i<keyboards.length; i++){
    		for(int j = 0; j<drives.length; j++){
    			int combinationSum = keyboards[i] + drives[j];
    			moneySpent = (combinationSum <= s && moneySpent < combinationSum) ? combinationSum : moneySpent;
    		}
    	}
    	
    	return moneySpent == 0 ? -1 : moneySpent;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}

/*

Monica wants to buy exactly one keyboard and one USB drive from her favorite electronics store. The store sells different brands of keyboards and  different brands of USB drives. Monica has exactly  dollars to spend, and she wants to spend as much of it as possible (i.e., the total cost of her purchase must be maximal).

Given the price lists for the store's keyboards and USB drives, find and print the amount money Monica will spend. If she doesn't have enough money to buy one keyboard and one USB drive, print -1 instead.

Note: She will never buy more than one keyboard and one USB drive even if she has the leftover money to do so.

Input Format

The first line contains three space-separated integers describing the respective values of  (the amount of money Monica has),  (the number of keyboard brands) and  (the number of USB drive brands). 
The second line contains  space-separated integers denoting the prices of each keyboard brand. 
The third line contains  space-separated integers denoting the prices of each USB drive brand.

Constraints

The price of each item is in the inclusive range .
Output Format

Print a single integer denoting the amount of money Monica will spend. If she doesn't have enough money to buy one keyboard and one USB drive, print -1 instead.

Sample Input 0

10 2 3
3 1
5 2 8
Sample Output 0

9
Explanation 0

She can buy the  keyboard and the  USB drive for a total cost of .

Sample Input 1

5 1 1
4
5
Sample Output 1

-1
Explanation 1

There is no way to buy one keyboard and one USB drive because , so we print .

*/