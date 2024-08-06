package solution.programmers.level2.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * 모음 사전
 */
public class Programmers84512 {
    private final static String[] characters = {"A", "E", "I", "O", "U"};
    private final static List<String> wordList = new ArrayList<>();

    public static void main(String[] args) {
        String word = "AAAAA";

        int answer = 0;
        createWordList("", 0);

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println("wordList = " + wordList.get(i));
            if (wordList.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        System.out.println("answer = " + answer);
//        return answer;
    }

    private static void createWordList(String str, int depth) {
        wordList.add(str);

        if (depth == 5) {
            return;
        }

        for (String ch : characters) {
            createWordList(str + ch, depth + 1);
        }
    }
}