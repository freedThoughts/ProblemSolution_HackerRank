package hackerProblems2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class QueensAttack2 {

    public static void main(String[] arg) {

        Set<Obstacle> set = new HashSet<>();
        //set.add(new Obstacle(1,2));
        System.out.println(new Obstacle(1, 2).equals(new Obstacle(1,2)));

        //System.out.println(queensAttack(5, 3, 4, 3, Arrays.asList(Arrays.asList(5, 5), Arrays.asList(4, 2), Arrays.asList(2, 3))));
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {

        Set<Obstacle> set = new HashSet<>();
        for (List<Integer> list : obstacles)
            set.add(new Obstacle(list.get(0), list.get(1)));

        int count = 0;
        Integer i = r_q +1;
        Integer j = c_q;
        while(i <=n && !set.contains(new Obstacle(i, j))) {
            i++; count++;
        }

        i = r_q-1;
        while(i >= 1 && !set.contains(new Obstacle(i, j))) {
            i--; count++;
        }

        j = c_q+1;
        i = r_q;
        while(j <= n && !set.contains(new Obstacle(i, j))) {
            j++;count++;
        }

        j = c_q-1;
        while(j >= 1 && !set.contains(new Obstacle(i, j))) {
            j--;count++;
        }

        i = r_q+1; j = c_q+1;
        while(i <= n && j <= n && !set.contains(new Obstacle(i, j))) {
            i++;j++;count++;
        }

        i = r_q+1; j = c_q-1;
        while(i <= n && j >= 1 && !set.contains(new Obstacle(i, j))) {
            i++;j--;count++;
        }

        i = r_q-1; j = c_q+1;
        while(i >= 1 && j <= n && !set.contains(new Obstacle(i, j))) {
            i--;j++;count++;
        }

        i = r_q-1; j = c_q-1;
        while(i >= 1 && j >= 1 && !set.contains(new Obstacle(i, j))) {
            i--;j--;count++;
        }

        return count;
    }

    static class Obstacle {
        Integer row;
        Integer col;

        Obstacle(Integer row, Integer col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Obstacle obstacle = (Obstacle) o;
            return Objects.equals(row, obstacle.row) &&
                    Objects.equals(col, obstacle.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
