package solution.programmers.level2.bfs;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411?language=java
 * 메뉴 리뉴얼
 */
class Programmers72411 {
    public static void main(String[] args) {
        String[] solution = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    private static HashMap<String, Integer> menu = new HashMap<>();
    private static int[] max;
    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        max = new int[course.length];

        for (int i = 0; i < orders.length; i++) {
            char[] orderArray = orders[i].toCharArray();
            Arrays.sort(orderArray);
            String str = String.copyValueOf(orderArray);

            for (int j = 0; j < course.length; j++) {
                combi(course[j], 0, j, str, "");
            }
        }

        for (int i = 0; i < max.length; i++) {
            for (Map.Entry<String, Integer> menuEntry : menu.entrySet()) {
                if (menuEntry.getKey().length() == course[i]
                        && menuEntry.getValue() >= 2
                        && menuEntry.getValue() == max[i]) {
                    answer.add(menuEntry.getKey());
                }
            }
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private static void combi(int cnt, int cur, int maxIdx, String order, String selectMenu) {
        if (cnt == selectMenu.length()) {
            menu.put(selectMenu, menu.getOrDefault(selectMenu, 0) + 1);
            max[maxIdx] = Math.max(max[maxIdx], menu.get(selectMenu));
            return;
        }

        for (int i = cur; i < order.length(); i++) {
            combi(cnt, i + 1, maxIdx, order, selectMenu + order.charAt(i));
        }
    }
}