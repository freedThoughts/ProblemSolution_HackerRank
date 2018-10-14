package implementation;

import java.util.Scanner;

public class BetweenTwoSets {
	
	static int hcf(int value1, int value2){
		while(value2 > 0){
			int temp = value2;
			value2 = value1 % value2;
			value1 = temp;
		}
		return value1;
	}
	
	static int hcfArray(int[] value){
		int result = value[0];
		for(int i = 1; i < value.length; i++) result = hcf(result, value[i]);
		return result;
	}
	
	static int lcm(int value1, int value2){
		return value1 * (value2 / hcf(value1, value2));
	}
	
	static int lcmArray(int[] value){
		int result = value[0];
		for(int i = 1; i<value.length; i++) result = lcm(result, value[i]);
		return result;
	}
	
    static int getTotalX(int[] a, int[] b) {
    	int hcf = hcfArray(a);
    	int lcm = lcmArray(b);
    	
    	System.out.println(hcf +"  "+ lcm);
    	
    	int resultCount = 0;
    	
    	int multipleValue = 1;
    	for(int i = 1; multipleValue<lcm; i++){
    		if(lcm % hcf*i == 0) resultCount++;
    		
    		multipleValue = hcf*i;
    	}
    	
/*    	int resultCount = 0;
    	for(int i = 0; i<b.length; i++)
    		if(b[i] % hcf == 0) resultCount++;*/

        return resultCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
