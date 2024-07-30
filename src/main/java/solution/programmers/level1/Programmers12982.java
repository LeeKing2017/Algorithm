package solution.programmers.level1;

import java.util.*;
public class Programmers12982 {
    static class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);
            int answer = 0;

            for(int amount : d) {
                if(budget < amount) {
                    break;
                }

                answer++;
                budget -= amount;
            }

            return answer;
        }
    }
}
