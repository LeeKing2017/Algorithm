package solution.programmers.level2.dfs;

import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * 전력망을 둘로 나누기
 */
public class Programmers86971 {
    public static void main(String[] args) {
        int solution = solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println("solution = " + solution);
    }
    public static int solution(int n, int[][] wires) {
        int answer = 100;
        Stack<Node> stack = new Stack<>();

        A : for (int i = 0; i < wires.length; i++) {
            boolean[] used = new boolean[wires.length];
            if (used[i]) {
                continue;
            }

            int groupCnt = 0;
            used[i] = true;

            for (int j = 0; j < wires.length; j++) {
                int tempCnt = 0;

                if (!used[j]) {
                    stack.push(new Node(wires[j][0], wires[j][1]));
                    used[j] = true;
                    tempCnt++;
                }

                while (!stack.isEmpty()) {
                    Node now = stack.pop();
                    for (int z = 0; z < wires.length; z++) {
                        if (used[z] || wires[z][0] != now.y) {
                            continue;
                        }

                        stack.push(new Node(wires[z][0], wires[z][1]));
                        used[z] = true;
                        tempCnt++;
                    }
                }

                if (tempCnt > 0) {
                    groupCnt = tempCnt;
                    answer = Math.min(answer, Math.abs(groupCnt - (n - groupCnt)));
                    used[i] = false;
                    continue A;
                }
            }
        }

        return answer;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
