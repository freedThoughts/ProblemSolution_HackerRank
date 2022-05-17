package hackerProblems2;

import java.util.List;

public class Three3dSurfaceArea {

    public static int surfaceArea(List<List<Integer>> A) {
        int count = 0;
        int maxRow = A.size()-1;
        int maxCol = A.get(0).size()-1;

        for(int j = 0; j <= maxCol; j++)
            count+= A.get(0).get(j);
        for(int i = 0; i <= maxRow; i++)
            count+= A.get(i).get(0);


        for(int i = 0; i <= maxRow; i++){
            for(int j = 0; j <= maxCol; j++) {
                int val = j == maxCol ? A.get(i).get(j) : A.get(i).get(j+1) > A.get(i).get(j) ? A.get(i).get(j+1) - A.get(i).get(j) : A.get(i).get(j) - A.get(i).get(j+1);

                count+=val;

                val = i == maxRow ? A.get(i).get(j) : A.get(i+1).get(j) > A.get(i).get(j) ? A.get(i+1).get(j) - A.get(i).get(j) : A.get(i).get(j) - A.get(i+1).get(j);
                count+= val;
            }
        }

        count += A.size()*A.get(0).size()*2;
        return count;
    }
}
