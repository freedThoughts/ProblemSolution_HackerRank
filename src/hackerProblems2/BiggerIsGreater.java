package hackerProblems2;
// https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        for(int i = w.length()-2; i>=0;i--) {
            if (w.charAt(i) < w.charAt(i+1)) {
                for(int j = w.length()-1; j > i; j--) {
                    if (w.charAt(i) < w.charAt(j)) {
                        char[] arr = w.toCharArray();
                        swap(arr, i, j);
                        reverse(arr, i+1);
                        return new String(arr);
                    }
                }
            }
        }
        return "no answer";
    }
    static void swap(char[] arr, int i, int j){
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void reverse(char[] arr, int i) {
        for(int j = arr.length-1; j > i; j--,i++)
            swap(arr, i, j);
    }
}
