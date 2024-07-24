package solution.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302?language=java
 * 거리두기 확인하기
 */
public class DistanceCheck {
    public static void main(String[] args) {
        solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static char[][] place;
    private static int[] answer = new int[]{1, 1, 1, 1, 1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[]{1, 1, 1, 1, 1};
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        A : for (int i = 0; i < 5; i++) {
            char[][] place = new char[5][5];
            for(int j = 0; j < 5; j++) {
                place[j] = places[i][j].toCharArray();
            }

            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (place[a][b] == 'P') {
                        for (int c = 0; c < 4; c++) {
                            int nx = dx[c] + a;
                            int ny = dy[c] + b;

                            if (nx < 0 || ny < 0 || nx > 4 || ny > 4) {
                                continue;
                            }

                            char next = place[nx][ny];
                            if (next == 'P'|| next == 'p') {
                                answer[i] = 0;
                                continue A;
                            }

                            if (next == 'O') {
                                place[nx][ny] = 'p';
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
