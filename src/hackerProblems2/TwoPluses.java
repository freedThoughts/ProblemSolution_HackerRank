package hackerProblems2;

import java.util.Arrays;
import java.util.List;

public class TwoPluses {
    public static void main(String[] arg) {
        List<String> grid = Arrays.asList(
                "GBGBGGB",
                "GBGBGGB",
                "GBGBGGB",
                "GGGGGGG",
                "GGGGGGG",
                "GBGBGGB",
                "GBGBGGB"
        );
        System.out.println(twoPluses(grid));
    }
    public static int twoPluses(List<String> grid) {
        int maxRow = grid.size()-1;
        int maxCol = grid.get(0).length()-1;
        Cell[][] matrix = new Cell[maxRow+1][maxCol+1];

        for(int i = maxRow; i >= 0; i--) {
            for (int j = maxCol; j >= 0; j--) {

                if (matrix[i][j] == null){
                    matrix[i][j] = new Cell();
                }

                if(grid.get(i).charAt(j) ==  'B') continue;

                matrix[i][j].down = i == maxRow ? 1 : 1+matrix[i+1][j].down;
                matrix[i][j].right = j == maxCol ? 1 : 1 + matrix[i][j+1].right;
            }
        }



        for(int i = 0; i <= maxRow; i++){
            for(int j = 0; j <= maxCol; j++) {
                if(grid.get(i).charAt(j) == 'B') continue;
                matrix[i][j].up = i == 0 ? 1 : 1 + matrix[i-1][j].up;
                matrix[i][j].left = j == 0 ? 1 : 1+matrix[i][j-1].left;
                matrix[i][j].maxArea = matrix[i][j].getMin();

            }
        }

        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i <= maxRow; i++){
            for (int j = 0; j <= maxCol; j++) {
                int max = matrix[i][j].getMin();
                max = (max-1)*4+1;
                if(max > secMax){
                    secMax = max;
                    if (secMax > firstMax) {
                        secMax = firstMax;
                        firstMax = max;
                    }
                }
            }
        }
        return firstMax * secMax;

    }

    static class Cell {
        int up;
        int down;
        int left;
        int right;
        int maxArea;

        int getMin(){
            return Math.min(up, Math.min(down, Math.min(left, right)));
        }
    }
}
