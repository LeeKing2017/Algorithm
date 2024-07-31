package solution.programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 154539
 */
public class Programmers154539 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 3, 3, 5});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        return answer;
    }

    // 완전 탐색 타임 아웃
/*    public static int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int now = numbers[i];
            int idx = i;
            while (true) {
                idx++;
                if (idx == n) {
                    answer[i] = -1;
                    break;
                }

                if (now < numbers[idx]) {
                    answer[i] = numbers[idx];
                    break;
                }
            }
        }
        return answer;
    }*/
}
