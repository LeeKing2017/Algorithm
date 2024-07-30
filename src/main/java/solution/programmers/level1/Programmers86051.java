package solution.programmers.level1;

import java.util.*;
import java.util.stream.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 * 없는 숫자 더하기
 */
public class Programmers86051 {
    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] numbers) {
        List<Integer> numList = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toList());

        for (int num : numbers) {
            numList.remove(Integer.valueOf(num));
        }

        return numList.stream().mapToInt(Integer::intValue).sum();
    }
}
