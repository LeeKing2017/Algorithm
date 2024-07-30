package solution.programmers.level3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 정수 삼각형
 */
public class Programmers43105 {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println("solution = " + solution);
    }
    private static int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] maps = new int[n][n];

        for(int i = 0; i < n; i++) {
            maps[n - 1][i] = triangle[n - 1][i];
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n - 1; j++) {
                maps[i][j] = Math.max(maps[i+1][j] + triangle[i][j], maps[i+1][j+1] + triangle[i][j]);
            }
        }

        return maps[0][0];
    }
}
