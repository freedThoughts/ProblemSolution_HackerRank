package hackerProblems;

import java.util.Scanner;

public class MonkVisitsCoderland {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int testCases = Integer.valueOf(s.split(" ")[0]);
		long[] answers = new long[testCases];
		for(int testCase = 0; testCase < testCases; testCase ++){
			s = in.nextLine();
			int checkPoints = Integer.valueOf(s.split(" ")[0]);
			s = in.nextLine();
			String[] s1 = s.split(" ");
			int[] rateAtCheckPoint = new int[checkPoints];
			for(int i = 0; i < checkPoints; i++){
				rateAtCheckPoint[i] = Integer.valueOf(s1[i]);
			}
			
			s = in.nextLine();
			s1 = s.split(" ");
			int[] petrolRequiredToReachNextCheckPoint = new int[checkPoints];
			for(int i = 0; i < checkPoints; i++){
				petrolRequiredToReachNextCheckPoint[i] = Integer.valueOf(s1[i]);
			}
			
			int lastProcessedIndex = checkPoints;
			long totalCost = 0;
			while(true){
				int currentIndex = getIndexWithMinRate(lastProcessedIndex -1 , rateAtCheckPoint);
				System.out.println("petrolRequiredToReachNextCheckPoint[currentIndex] "+petrolRequiredToReachNextCheckPoint[currentIndex]);
				totalCost = totalCost + rateAtCheckPoint[currentIndex] * ((long)getPetrolRequired(currentIndex, lastProcessedIndex -1, petrolRequiredToReachNextCheckPoint));
				System.out.println(totalCost);
				if(currentIndex == 0)
					break;
				
				lastProcessedIndex = currentIndex;
			}
			answers[testCase] = totalCost;
		}
		
		in.close();
		for(int i = 0; i < testCases; i++)
			System.out.println(answers[i]);

	}
	
	private static int getIndexWithMinRate(int end, int[] rateAtCheckPoint){
		int minIndex = 0;
		for(int i = 0; i<= end; i++){
			minIndex = rateAtCheckPoint[i] < rateAtCheckPoint[minIndex] ? i : minIndex;
		}
		System.out.println("Min Index " + minIndex);
		System.out.println("rateAtCheckPoint[minIndex] " + rateAtCheckPoint[minIndex]);
		return minIndex;
	}
	
	private static long getPetrolRequired(int startIndex, int endIndex, int[] petrolRequiredToReachNextCheckPoint){
		long petrolRequired = 0;
		for(int i = startIndex; i <= endIndex; i++)
			petrolRequired = petrolRequired + petrolRequiredToReachNextCheckPoint[i];
		System.out.println("petrolRequired " + petrolRequired);
		return petrolRequired;
	}

}
