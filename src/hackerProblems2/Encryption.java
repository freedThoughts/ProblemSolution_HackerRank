package hackerProblems2;

// https://www.hackerrank.com/challenges/encryption/problem
public class Encryption {
    public static void main(String[] arg) {
        System.out.println(encryption("iffactsdontfittotheorychangethefacts"));
    }

    public static String encryption(String s) {
        char[] arr = new char[s.length()];
        int i = 0;
        for(char c: s.toCharArray())
            if (c != ' ')
                arr[i++] = c;

        int maxRow = (int)Math.sqrt(i);
        int maxCol = Math.sqrt(i) - maxRow == 0 ? maxRow : maxRow+1;

        char[] ans = new char[i+maxCol-1];
        int ansIndex = 0;

        for(int k = 0; k < maxCol; k++) {
            if(ansIndex!= 0) ans[ansIndex++] = ' ';

            for(int n = k;n<i ; n+=maxCol)
                ans[ansIndex++] = arr[n];
        }
        return new String(ans);
    }
}
