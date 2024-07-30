package solution.programmers.level3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 * 기지국 설치
 */
public class Programmers12979 {
    public static void main(String[] args) {
        int solution = solution(11, new int[]{4, 11}, 1);
        System.out.println("solution = " + solution);
    }
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;
        int idx = 0;

        while (location <= n) {
            if (idx <= stations.length - 1 && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            } else {
                location += w * 2 + 1;
                answer++;
            }
        }

        return answer;
    }
}
