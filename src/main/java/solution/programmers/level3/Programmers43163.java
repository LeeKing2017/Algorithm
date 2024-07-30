package solution.programmers.level3;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * 단어 변환
 */
class Programmers43163 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words)); // 4
    }

    static class WordNode {
        String word;
        int depth;

        WordNode(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    private static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        java.util.Stack<WordNode> stack = new Stack<>();
        stack.push(new WordNode(begin, 0));

        while (!stack.isEmpty()) {
            WordNode node = stack.pop();
            String currentWord = node.word;
            int currentDepth = node.depth;

            if (currentWord.equals(target)) {
                return currentDepth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneLetterDifferent(currentWord, words[i])) {
                    visited[i] = true;
                    stack.push(new WordNode(words[i], currentDepth + 1));
                }
            }
        }

        return 0; // 변환할 수 없는 경우 0 반환
    }

    private static boolean isOneLetterDifferent(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
