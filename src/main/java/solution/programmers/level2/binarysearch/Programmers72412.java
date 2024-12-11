package solution.programmers.level2.binarysearch;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * 순위 검색 (2021 카카오)
 */
public class Programmers72412 {
    private static final String ANY = "-";
    private static HashMap<String, List<Integer>> MAP = new HashMap<>();
    public int[] solution(String[] info, String[] query) { // info -> 개발언어, 직군, 경력, 소울푸드, 점수 순
        int[] answer = new int[query.length];
        // info의 모든 경우의 수 만들기
        for (String i : info) {
            makeKeys(i.split(" "), "", 0);
        }

        // binarySearch를 위한 정렬
        for (String key : MAP.keySet()) {
            Collections.sort(MAP.get(key));
        }

        // query의 대한 답 구하기
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = MAP.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    private void makeKeys(String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!MAP.containsKey(str)) {
                List<Integer> l = new ArrayList<>();
                MAP.put(str, l);
            }

            MAP.get(str).add(Integer.valueOf(p[4]));
            return;
        }

        makeKeys(p, str + p[cnt], cnt + 1);
        makeKeys(p, str + ANY, cnt + 1);
    }

    private int binarySearch(String key, int score) {
        List<Integer> scores = MAP.get(key);
        int start = 0, end = scores.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scores.size() - start;
    }
}
