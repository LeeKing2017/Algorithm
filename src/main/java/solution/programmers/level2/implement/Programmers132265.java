package solution.programmers.level2.implement;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * 롤케이크 자르기
 */
public class Programmers132265 {

    static class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            HashSet<Integer> chul = new HashSet<>();
            HashMap<Integer, Integer> young = new HashMap<>();
            for(int a : topping) {
                young.put(a, young.getOrDefault(a, 0) + 1);
            }

            int toppingCnt = young.size();

            for(int b : topping) {
                if (young.get(b) == 1) {
                    young.remove(b);
                } else {
                    young.put(b, young.get(b) - 1);
                }

                chul.add(b);

                if (young.size() == chul.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
