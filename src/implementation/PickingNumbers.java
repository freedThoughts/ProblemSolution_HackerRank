package implementation;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class PickingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(a);
        int maxCount = 0;
        for(int i = 0; i<n; i++){
        	if(i>0 && a[i] == a[i-1])
        		continue;
        	
        	int iCount = 0;
        	for(int j = i; j<n; j++){
        		if(a[j] - a[i] <= 1)
        			iCount ++;
        		else 
        			break;
        	}
        	maxCount = maxCount < iCount ? iCount : maxCount;
        }
        System.out.println(maxCount);
        
/*        // Using TreeMap to get SortedMap
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
        	if(map.containsKey(a[i])) map.put(a[i], map.get(a[i])+1);
        	else map.put(a[i], 1);
        }
        
        int previousKey = 0;
        int totalConsecutiveIntegers = 0;
        for(Entry<Integer, Integer> entry : map.entrySet()){
      	
        	if(previousKey == 0) {
        		previousKey = entry.getKey();
        		continue;
        	}
        	if(Math.abs(entry.getKey() - previousKey) <= 1){
        		int consecutiveIntegers = entry.getValue() + map.get(previousKey);
        		totalConsecutiveIntegers = totalConsecutiveIntegers < consecutiveIntegers ? consecutiveIntegers : totalConsecutiveIntegers;
        	}
    		previousKey = entry.getKey();
        }
        
        System.out.println(totalConsecutiveIntegers);*/
        
    }
}



/*

Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is .

Input Format

The first line contains a single integer, , denoting the size of the array. 
The second line contains  space-separated integers describing the respective values of .

Constraints

The answer will be .
Output Format

A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is .

Sample Input 0

6
4 6 5 3 3 1
Sample Output 0

3
Explanation 0

We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e.,  and ), so we print the number of chosen integers, , as our answer.

Sample Input 1

6
1 2 2 3 1 2
Sample Output 1

5
Explanation 1

We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer.


 * 
 */
