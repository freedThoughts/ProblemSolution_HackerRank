package hackerProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MonkAndHisBirthdayParty {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int testCases = Integer.valueOf(s.split(" ")[0]);
		long[] answers = new long[testCases];
		for(int testCase = 0; testCase < testCases; testCase ++){
			s = in.nextLine();
			int cakeType = Integer.valueOf(s.split(" ")[0]);
			int numOffriends = Integer.valueOf(s.split(" ")[1]);
			
			s = in.nextLine();
			String[] s1 = s.split(" ");
			Long[] eatingCapacity = new Long[numOffriends];
			for(int i = 0; i< numOffriends; i++)
				eatingCapacity[i] = Long.valueOf(s1[i]);
			
			Arrays.sort(eatingCapacity, new Comparator<Long>(){
				@Override
				public int compare(Long o1, Long o2) {
					return -((Long) o1).compareTo((Long)o2);
				}
				
			});
			
			Long sumOfFriendsCapacity = 0L;
			for(int i = 0; i < numOffriends; i++)
				sumOfFriendsCapacity = sumOfFriendsCapacity + eatingCapacity[i];
			
			s = in.nextLine();
			String[] weight = s.split(" ");
			s = in.nextLine();
			String[] availability = s.split(" ");
			
			Map<Long, Long> map = new TreeMap<Long, Long>(new Comparator<Long>(){
				@Override
				public int compare(Long o1, Long o2) {
					return -((Long) o1).compareTo((Long)o2);
				}});
			
			Long totalWeightOfCakesAllAvailable = 0L;
			Long biggestCakeWeight = 0L;
			for(int i = 0; i < cakeType; i++){
				biggestCakeWeight = biggestCakeWeight < Long.valueOf(weight[i]) ? Long.valueOf(weight[i]) : biggestCakeWeight;
				map.put(Long.valueOf(weight[i]), Long.valueOf(availability[i]));
				totalWeightOfCakesAllAvailable = totalWeightOfCakesAllAvailable + Long.valueOf(weight[i]) * Long.valueOf(availability[i]);
			}
			
			if(biggestCakeWeight > eatingCapacity[0]){
				answers[testCase] = 1;
				System.out.println("myValue " + answers[testCase]);
				continue;
			}
			
			Long[] weights = new Long[cakeType];
			for(int i = 0; i < cakeType; i++){
				weights[i] = Long.valueOf(weight[i]);
			}
			
			
			Arrays.sort(weights, new Comparator<Long>(){
				@Override
				public int compare(Long o1, Long o2) {
					return -((Long) o1).compareTo((Long)o2);
				}
				
			});
			
			for(int i = 0; i < weights.length; i++){
				System.out.println("weights " + weights[i]);
			}
			
			Long numOfCakeEatenByIndivisual = totalWeightOfCakesAllAvailable % sumOfFriendsCapacity > 0 ? (totalWeightOfCakesAllAvailable/sumOfFriendsCapacity +1) : 
				totalWeightOfCakesAllAvailable/sumOfFriendsCapacity;
			
			for(int i = 0; i < eatingCapacity.length; i++){
				System.out.println("eatingCapacity " + eatingCapacity[i]);
			}
						
			System.out.println("numOfCakeEatenByIndivisual " + numOfCakeEatenByIndivisual);
			boolean flag = false;
			for(Long l = numOfCakeEatenByIndivisual; l < 10 && !flag; l++){
				numOfCakeEatenByIndivisual = l;
				for(int i = 0; i < eatingCapacity.length; i++){
					int numOfCakeEatenByHim = 0;
					for(int j = 0; j < cakeType && numOfCakeEatenByHim < l; j++){
						if(weights[j] <= eatingCapacity[i] && map.get(weights[j]) > 0){
							numOfCakeEatenByHim ++;
							map.put(weights[j], map.get(weights[j]) -1);
						}
					}
				}
				
				for(Map.Entry<Long, Long> e : map.entrySet()){
					if(e.getValue() > 0){
						answers[testCase] = 1;
						flag = true;
						break;
					}
				}
			}
			
			if(flag)
				answers[testCase] = numOfCakeEatenByIndivisual;

		}
		
		in.close();
		for(int i = 0; i < testCases; i++)
			System.out.println(answers[i]);

	}

}
