package implementation;

import java.util.Scanner;

public class CountingValleys {
	
	public static void main(String [] arg) {
		Scanner scanner = new Scanner(System.in);
		int totalSteps = scanner.nextInt();
		String steps = scanner.next();
		
		int presentHeight = 0;
		boolean onTheWayToValley = false;
		int valleyCount = 0;
		for(char c : steps.toCharArray()){
			if(c == 'U'){
				presentHeight ++;
				if(presentHeight == 0 && onTheWayToValley){
					valleyCount ++;
					onTheWayToValley = false;
				}
			}
			
			if(c == 'D'){
				if(presentHeight == 0){
					onTheWayToValley = true;
				}
				presentHeight --;
			}
		}
		
		System.out.println(valleyCount);

		
	}

}

/*

Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike, he took exactly  steps. For every step he took, he noted if it was an uphill or a downhill step. Gary's hikes start and end at sea level. We define the following terms:

A mountain is a non-empty sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a non-empty sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

Input Format

The first line contains an integer, , denoting the number of steps in Gary's hike. 
The second line contains a single string of  characters. Each character is  (where U indicates a step up and D indicates a step down), and the  character in the string describes Gary's  step during the hike.

Constraints

Output Format

Print a single integer denoting the number of valleys Gary walked through during his hike.

Sample Input

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/
It's clear that there is only one valley there, so we print  on a new line.

*/