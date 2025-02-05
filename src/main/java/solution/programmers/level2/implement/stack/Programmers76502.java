package solution.programmers.level2.implement.stack;

import java.util.Stack;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/76502
 *  괄호 회전하기
 */
public class Programmers76502 {
    public int solution(String s) {
        int answer = 0;
        int cur = 0;
        int l = s.length();
        char[] initData = (s + s).toCharArray();

        for (int i = cur++; i < l; i++) {
            Stack<Character> stack = new Stack<>();

            for (int j = i; j < i + l; j++) {

                char now = initData[j];
                if (isLeft(now)) {
                    stack.push(now);
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }

                    char pop = stack.pop();
                    if (isSame(pop, now)) {
                        if (j == i + l - 1 && stack.isEmpty()) {
                            answer++;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isLeft(char c) {
        return c == '[' || c == '(' || c == '{';
    }

    private static boolean isSame(char left, char right) {
        if (left == '[' && right == ']') {
            return true;
        } else if (left == '{' && right == '}') {
            return true;
        } else if (left == '(' && right == ')') {
            return true;
        } else {
            return false;
        }
    }
}
