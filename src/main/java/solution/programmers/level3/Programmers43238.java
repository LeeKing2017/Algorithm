package solution.programmers.level3;

import java.util.Arrays;

public class Programmers43238 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = new int[]{7, 10};
        long solution = solution(n, times);

        System.out.println("solution = " + solution);
    }
    private static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 1;
        long right = n * times[times.length - 1];

        while (left <= right) {
            long result = (left + right) / 2;
            long complete = getCompletePerson(times, result);

            if (complete < n) {
                left = result + 1;
            } else if (complete == n) {
              if (getCompletePerson(times, result - 1) != n) {
                  right = result - 1;
                  answer = result;
              }
            } else {
                right = result - 1;
                answer = result;
            }
        }

        return answer;
    }

    private static long getCompletePerson(int[] times, long mid) {
        long complete = 0;
        for (int i = 0; i < times.length; i++) {
            complete += mid / times[i];
        }
        return complete;
    }
}
