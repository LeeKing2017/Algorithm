package solution.programmers.level2.implement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 호텔 대실
 */
public class Programmers155651 {
    public static void main(String[] args) {
        int solution1 = solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        System.out.println("solution1 = " + solution1);
        int solution2 = solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}});
        System.out.println("solution1 = " + solution2);
        int solution3 = solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}});
        System.out.println("solution1 = " + solution3);
    }

    private static int[][] times;
    public static int solution(String[][] book_time) {
        PriorityQueue<int[]> booked = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1]));
        initValue(book_time);
        Arrays.sort(times, Comparator.comparingInt(o1 -> o1[0]));

        for (int[] time : times) {
            if (booked.isEmpty()) {
                booked.add(time);
            } else {
                int[] peek = booked.peek();
                // 교체할 수 있는 방이 있다면 큐에서 삭제
                if (time[0] >= peek[1]) {
                    booked.poll();
                }

                booked.add(time);
            }
        }

        return booked.size();
    }

    private static void initValue(String[][] book_time) {
        times = new int[book_time.length][book_time[0].length];
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            String[] endSplit = book_time[i][1].split(":");
            int endHour = Integer.parseInt(endSplit[0]);
            int endMinutes = Integer.parseInt(endSplit[1]) + 10;

            if (endMinutes >= 60) {
                endHour += 1;
                endMinutes -= 60;
            }

            int end = endHour * 100 + endMinutes;
            times[i] = new int[]{start, end};
        }
    }
}
