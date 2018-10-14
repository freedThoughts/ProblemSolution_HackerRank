package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i<n; i++){
    		if(map.containsKey(ar[i])) map.put(ar[i], map.get(ar[i])+1); 
    		else map.put(ar[i], 1);
    	}
    	
    	int resultKey = 5;
    	int resultValue = 0;
    	
    	for(Entry<Integer, Integer> entry : map.entrySet()){
    		if(entry.getValue() > resultValue) {
    			resultKey = entry.getKey();
    			resultValue = entry.getValue();
    		}
    		else if(entry.getValue() == resultValue && entry.getKey() < resultKey){
    			resultKey = entry.getKey();
    			resultValue = entry.getValue();
    		}
    	}
    	
    	return resultKey;
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

/*

A flock of  birds is flying across the continent. Each bird has a type, and the different types are designated by the ID numbers , , , , and .

Given an array of  integers where each integer describes the type of a bird in the flock, find and print the type number of the most common bird. If two or more types of birds are equally common, choose the type with the smallest ID number.

Input Format

The first line contains an integer denoting  (the number of birds). 
The second line contains  space-separated integers describing the respective type numbers of each bird in the flock.

Constraints

It is guaranteed that each type is , , , , or .
Output Format

Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.

Sample Input 0

6
1 4 4 4 5 3
Sample Output 0

4
Explanation 0

The different types of birds occur in the following frequencies:

Type :  bird
Type :  birds
Type :  bird
Type :  birds
Type :  bird
The type number that occurs at the highest frequency is type , so we print  as our answer.

*/