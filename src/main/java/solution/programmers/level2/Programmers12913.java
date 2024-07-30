package solution.programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 * 땅따먹기
 */
public class Programmers12913 {
    private static int y = 0;
    private static int answer = 0;
    private static int[][] Land;

    public static void main(String[] args) {
        int solution = solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
        System.out.println("solution = " + solution);
    }
    private static int solution(int[][] land) {
        y = land.length; //3
        Land = land;

        dfs(0, 0, -1);

        return answer;
    }

    private static void dfs(int sum, int depth, int previousX) {
        if (depth == y) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (previousX == i) {
                continue;
            }
            dfs(sum + Land[depth][i], depth + 1, i);
        }
    }
}
