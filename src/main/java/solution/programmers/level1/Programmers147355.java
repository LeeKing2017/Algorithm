package solution.programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 * 크기가 작은 부분 문자열
 */
public class Programmers147355 {
    public static void main(String[] args) {
        int solution = solution("500220839878", "7");
        System.out.println("solution = " + solution);
    }

    public static int solution(String t, String p) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < t.length(); i++) {
            if (i + (p.length() - 1) >= t.length()) {
                break;
            }

            StringBuilder temp = new StringBuilder();
            // p의 길이만큼 잘라서 저장
            for (int j = i; j < i + p.length(); j++) {
                temp.append(t.charAt(j));
            }
            list.add(Integer.parseInt(temp.toString()));
        }

        int pInt = Integer.parseInt(p);

        return list.stream()
                .filter(o1 -> o1 <= pInt)
                .collect(Collectors.toList())
                .size();
    }
}
