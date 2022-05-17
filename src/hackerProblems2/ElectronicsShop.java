package hackerProblems2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ElectronicsShop {

    static int getMoneySpent2(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int i = 0, j = 0;
        if (keyboards[i] + drives[j] > b) return -1;

        while(true) {

            boolean keyboradPriceAfford = i != keyboards.length-1 && keyboards[i+1] + drives[j] <= b;
            boolean drivesPriceAfford = j != drives.length-1 && keyboards[i] + drives[j+1] <= b;

            if (!keyboradPriceAfford && !drivesPriceAfford) break;
            if (keyboradPriceAfford && drivesPriceAfford) {
                if ((keyboards[i+1] - keyboards[i]) > (drives[j+1] - drives[j])) i++;
                else j++;
                continue;
            }
            if (keyboradPriceAfford) i++;
            if (drivesPriceAfford) j++;
        }

        return keyboards[i] + drives[j];
    }

    public static void main(String[] arg) {
        System.out.println(getMoneySpent2(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
    }

/*
    static int getMoneySpent1(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        if (keyboards[0] + drives[0] > b) return -1;
        int i = keyboards.length-1, j = drives.length-1;
        while(true) {
            if (keyboards[i] + drives[j] <= b) return keyboards[i] + drives[j];

            boolean isKeyboardsPriceReduce = i != 0 && keyboards[i-1] + drives[j] > b;
            boolean isDrivesPriceReduce = j != 0 && keyboards[i] + drives[j-1] > b;

            if (!isKeyboardsPriceReduce && !isDrivesPriceReduce) {
                if (i == 0) {
                    j--;
                    continue;
                }
                if (j == 0) {
                    i--;
                    continue;
                }
                if(keyboards[i] - keyboards[i-1] > drives[j] - drives[j-1]) j--;
                else i--;
                continue;
            }

            if (isKeyboardsPriceReduce && isDrivesPriceReduce) {
                if(keyboards[i] - keyboards[i-1] > drives[j] - drives[j-1]) i--;
                else j--;
                continue;
            }

            if (isKeyboardsPriceReduce) i--;
            if (isDrivesPriceReduce) j--;
        }

    }

    public static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }

    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        Comparator<int> comparator = (m, n) -> ((Integer)n).compareTo( (Integer)m);
        Arrays.sort(keyboards, Collections.reverseOrder()


        );
        Arrays.sort(drives, (m, n) -> ((Integer)n).compareTo( (Integer)m));

        if (keyboards[keyboards.length-1] + drives[drives.length-1] > b) return -1;
        int i = 0, j = 0;
        while(true) {
            boolean isKeyboardsPriceReduce = i != keyboards.length-1 && keyborads[i+1] + drives[j] > b;
            boolean isDrivesPriceReduce = j != drives.length-1 && keyboards[i] + drives[j+1] > b;

            if (!isKeyboardsPriceReduce && !isDrivesPriceReduce) return keyborads[i] + drives[j];

            if (isKeyboardsPriceReduce && isDrivesPriceReduce) {
                if(keyboards[i] - keyboards[i+1] > drives[j] - drives[j+1]) i++;
                else j++;
                continue;
            }

            if (isKeyboardsPriceReduce) i++;
            if (isDrivesPriceReduce) j++;
        }

        return -1;
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyborrds,
                (a, b) -> ((Integer)b).compareTo( (Integer)a)

        );
        Arrays.sort(drives, (a, b) -> ((Integer)b).compareTo( (Integer)a));

        if (keyboards[keyboards.length-1] + drives[drives.length-1] > b) return -1;
        int i = 0, j = 0;
        while(true) {
            boolean isKeyboardsPriceReduce = i != keyboards.length-1 && keyborads[i+1] + drives[j] > b;
            boolean isDrivesPriceReduce = j != drives.length-1 && keyboards[i] + drives[j+1] > b;

            if (!isKeyboardsPriceReduce && !isDrivesPriceReduce) return keyborads[i] + drives[j];

            if (isKeyboardsPriceReduce && isDrivesPriceReduce) {
                if(keyboards[i] - keyboards[i+1] > drives[j] - drives[j+]) i++;
                else j++;
                continue;
            }

            if (isKeyboardsPriceReduce) i++;
            if (isDrivesPriceReduce) j++;
        }

        return -1;
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        if (keyboards[0] + drives[0] > b) return -1;

        int i = keyboards.length-1;
        int j = drives.length-1;
        long sum = keyboards[i] + drives[j];

        while(sum > b && (i >= 0 || j >=0)) {
            long diff = sum - b;
            int keyDiff = i != 0 ? keyboards[i] - keyboards[i-1] : Integer.MAX_VALUE;
            int drivesDiff = j != 0 ? drives[j] - drives[j-1]: Integer.MAX_VALUE;

            if (keyDiff < diff && drivesDiff < diff) {
                if (keyDiff > drivesDiff ) {
                    sum -=keyDiff;
                    i--;
                } else {
                    sum -= drivesDiff;
                    j--;
                }
            } else {
                if (keyDiff < drivesDiff) {
                    sum -=keyDiff;
                    i--;
                } else {
                    sum -= drivesDiff;
                    j--;
                }
            }
        }

        return (int)sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        *//*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         *//*

        int moneySpent = getMoneySpent(keyboards, drives, b);

*//*        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();*//*

        scanner.close();
    }*/
}
