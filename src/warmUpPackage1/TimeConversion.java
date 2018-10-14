package warmUpPackage1;

import java.util.Scanner;

public class TimeConversion {
    static String timeConversion(String s) {
    	int intHour = Integer.parseInt(s.substring(0, 2));
    	String minSec = s.substring(2, 8);
    	String AMPM = s.substring(8);
    	
    	if("AM".equals(AMPM) && intHour == 12) intHour = 0;
    	if("PM".equals(AMPM) && intHour != 12) intHour = intHour+12;
    	
    	return String.format("%02d", intHour)+minSec;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
