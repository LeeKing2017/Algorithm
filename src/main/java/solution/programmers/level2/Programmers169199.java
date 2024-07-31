package solution.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/169199
 * 리코쳇 로봇
 */
public class Programmers169199 {
    public static void main(String[] args) {
        int solution1 = solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        System.out.println("solution = " + solution1);
        int solution2 = solution(new String[]{".D.R", "....", ".G..", "...D"});
        System.out.println("solution = " + solution2);
    }

    private static Node START;
    private static Node END;
    private static final int BLOCK_VALUE = -1;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    public static int solution(String[] board) {
        int[][] Board = new int[board.length][board[0].length()];
        boolean[][] used = new boolean[board.length][board[0].length()];
        init(board, Board);

        Queue<Node> q = new LinkedList<>();
        q.add(START);
        used[START.x][START.y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if ((nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length())) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }

                    if (Board[nx][ny] == BLOCK_VALUE) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                if (!used[nx][ny]) {
                    q.add(new Node(nx, ny));
                    used[nx][ny] = true;
                    Board[nx][ny] = Board[now.x][now.y] + 1;
                }
            }
        }
        int answer = Board[END.x][END.y];
        return answer == 0 ? -1 : answer;
    }

    private static void init(String[] board, int[][] Board) {
        for (int i = 0; i < board.length; i++) {
            String[] split = board[i].split("");
            for (int j = 0; j < split.length; j++) {
                char n = split[j].charAt(0);
                if (n == 'R') {
                    START = new Node(i, j);
                } else if (n == 'D') {
                    Board[i][j] = BLOCK_VALUE;
                } else if (n == 'G') {
                    END = new Node(i, j);
                }
            }
        }
    }

    public static class Node {
        int x, y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
