package solution.programmers.level2.implement;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 * 행렬 테두리 회전하기
 */
public class Programmers77485 {
    public static void main(String[] args) {
        int[] solution = solution(100, 97, new int[][]{{1,1,100,97}});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static int[] solution(int rows, int columns, int[][] queries) {
        int moveCnt = queries.length;
        int[] answer = new int[moveCnt];
        int[][] matric = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                matric[r][c] = c + 1 + (r * columns);
            }
        }

        for(int i = 0; i < moveCnt; i++) {
            Point startPoint = new Point(queries[i][0] - 1, queries[i][1] - 1);
            Point endPoint = new Point(queries[i][2] - 1, queries[i][3] - 1);
            answer[i] = moveMatric(matric, startPoint, endPoint);
        }

        return answer;
    }

    static int moveMatric(int[][] matric, Point start, Point end) {
        int last = matric[start.r][start.c];
        int minResult = last;

        for (int i = start.r; i < end.r; i++) {
            minResult = Math.min(minResult, matric[i][start.c]);
            matric[i][start.c] = matric[i + 1][start.c];
        }

        for (int i = start.c; i < end.c; i++) {
            minResult = Math.min(minResult, matric[end.r][i]);
            matric[end.r][i] = matric[end.r][i + 1];
        }

        for (int i = end.r; i > start.r; i--) {
            minResult = Math.min(minResult, matric[i][end.c]);
            matric[i][end.c] = matric[i - 1][end.c];
        }

        for (int i = end.c; i > start.c; i--) {
            minResult = Math.min(minResult, matric[start.r][i]);
            matric[start.r][i] = matric[start.r][i - 1];
        }

        matric[start.r][start.c + 1] = last;

        return minResult;
    }

    static class Point {
        int r,c;

        Point (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
