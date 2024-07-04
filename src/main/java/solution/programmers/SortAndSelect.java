package solution.programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * K번째수
 */
public class SortAndSelect {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println("solution = " + Arrays.toString(solution));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int g = 0; g < commands.length; g++) {
            int i = commands[g][0] - 1;
            int j = commands[g][1] - 1;
            int k = commands[g][2] - 1;
            int[] arr = new int[j - i + 1];

            for(int l = i; l <= j; l++) {
                arr[l - i] = array[l];
            }

            Arrays.sort(arr);
            answer[g] = arr[k];
        }

        return answer;
    }
}
