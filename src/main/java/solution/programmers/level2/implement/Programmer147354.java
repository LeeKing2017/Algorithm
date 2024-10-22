package solution.programmers.level2.implement;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354?language=java
 * 테이블 해시 함수
 */
public class Programmer147354 {

    public static void main(String[] args) {
        int solution = solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, Comparator.comparing((int[] tuple) -> tuple[col-1])
                .thenComparing((int[] tuple) -> tuple[0], Comparator.reverseOrder()));

        for(int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int m = 0; m < data[i].length; m++) {
                sum += data[i][m] % (i + 1);
            }
            answer ^= sum;
        }

        return answer;
    }
}
