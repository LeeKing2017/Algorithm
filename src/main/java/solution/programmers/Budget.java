package solution.programmers;

import java.util.*;
public class Budget {
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
