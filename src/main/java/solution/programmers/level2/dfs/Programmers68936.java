package solution.programmers.level2.dfs;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 * 쿼드압축 후 개수 세기
 */
public class Programmers68936 {
    private static int[][] Arr;
    private static int[] answer;

    public int[] solution(int[][] arr) {
        Arr = arr;
        answer = new int[2];

        dp(0, 0, Arr.length);
        return answer;
    }

    private static void dp(int x, int y, int size) {
        if (check(x, y, size)) {
            answer[Arr[x][y]]++;
            return;
        }

        int nextSize = size / 2;
        dp(x, y, nextSize);
        dp(x + nextSize, y, nextSize);
        dp(x, y + nextSize, nextSize);
        dp(x + nextSize, y + nextSize, nextSize);
    }

    private static boolean check(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (Arr[x][y] != Arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
