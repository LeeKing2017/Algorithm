package solution.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SliceCake {
    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        System.out.println("solution = " + solution);
    }
    public static int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        for(int i = 1; i < n; i++) {
            List<Integer> old = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                old.add(topping[j]);
            }

            List<Integer> young = new ArrayList<>();
            for (int z = i; z < n; z++) {
                young.add(topping[z]);
            }

            int oldToppingCnt = old.stream().distinct().collect(Collectors.toList()).size();
            int youngToppingCnt = young.stream().distinct().collect(Collectors.toList()).size();

            if(oldToppingCnt == youngToppingCnt) {
                answer++;
            }
        }
        return answer;
    }
}
