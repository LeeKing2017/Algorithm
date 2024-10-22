package solution.programmers.level2.implement;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 택배 상자
 */
public class Programmers131704 {
    public static void main(String[] args) {
        int solution = solution(new int[]{4, 3, 1, 2, 5});
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> sub = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            sub.push(i);
            while(!sub.isEmpty()) {
                if (sub.peek() == order[idx]) {
                    sub.pop();
                    idx++;
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
