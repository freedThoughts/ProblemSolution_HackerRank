package hackerProblems2;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Grading {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(a -> {
            if (a < 38) return a;
            if (a%5 > 2) return a + (5- a%5);
            return a;
        })
                .collect(Collectors.toList());

    }
}
