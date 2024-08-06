package solution.programmers.level2.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 연속된 부분 수열의 합
 */
public class Programmers178870 {
    public static void main(String[] args) {
        int[] solution1 = solution(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println("solution1 = " + Arrays.toString(solution1));
        int[] solution2 = solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("solution2 = " + Arrays.toString(solution2));
        int[] solution3 = solution(new int[]{2, 2, 2, 2, 2}, 6);
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }

    static int[] solution(int[] sequence, int k) {
        ArrayList<Node> results = new ArrayList<>();
        int left = 0, right = 1, sum = sequence[left];

        while (left < right) {
            if (sum == k) {
                results.add(new Node(left, right - 1, right - left + 1));
                sum -= sequence[left++];
            } else if (sum > k) {
                sum -= sequence[left++];
            } else if (right < sequence.length) {
                sum += sequence[right++];
            } else {
                break;
            }
        }

        Node node = results.stream()
                .min(Comparator.comparing(Node::getSize)
                        .thenComparing(Node::getStartIdx))
                .get();

        return new int[]{node.startIdx, node.endIdx};
    }

    static class Node {
        int startIdx, endIdx, size;

        public int getStartIdx() {
            return startIdx;
        }

        public int getSize() {
            return size;
        }

        public Node(int startIdx, int endIdx, int size) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.size = size;
        }
    }
}
