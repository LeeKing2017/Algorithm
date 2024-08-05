package solution.programmers.level2;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160585
 * 혼자서 하는 틱택토
 */
public class Programmers160585 {
    public static void main(String[] args) {
        int solution1 = solution(new String[]{"O.X", ".O.", "..X"});
        System.out.println("solution = " + solution1);
        int solution2 = solution(new String[]{"OOO", "...", "XXX"});
        System.out.println("solution = " + solution2);
        int solution3 = solution(new String[]{"...", ".X.", "..."});
        System.out.println("solution = " + solution3);
        int solution4 = solution(new String[]{"...", "...", "..."});
        System.out.println("solution = " + solution4);
    }

    private static String[] Board;
    private static final int BOARD_SIZE = 3;
    private static final int CORRECT_GAME = 1;
    private static final int WRONG_GAME = 0;
    public static int solution(String[] board) {
        Board = board;
        int oCnt = count('O');
        int xCnt = count('X');

        // O가 X보다 두개 많을 경우
        if (oCnt > xCnt + 1) {
            return WRONG_GAME;
        }

        // X가 O보다 두개 많을 경우
        if (xCnt > oCnt) {
            return WRONG_GAME;
        }

        // O가 빙고인데 더 진행한 경우
        if (isWin('O') && oCnt == xCnt) {
            return WRONG_GAME;
        }

        // X가 빙고인데 더 진행한 경우
        if (isWin('X') && oCnt > xCnt) {
            return WRONG_GAME;
        }

        return CORRECT_GAME;
    }

    private static int count(char ch) {
        int cnt = 0;
        for (String s : Board) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (s.charAt(j) == ch) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean isWin(char ch) {
        boolean isWin = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            // 가로 빙고
            if (Board[i].charAt(0) == ch && Board[i].charAt(1) == ch && Board[i].charAt(2) == ch) {
                isWin = true;
            }

            // 세로 빙고
            if (Board[0].charAt(i) == ch && Board[1].charAt(i) == ch && Board[2].charAt(i) == ch) {
                isWin = true;
            }
        }

        // 오른쪽 아래로 향하는 대각선
        if (Board[0].charAt(0) == ch && Board[1].charAt(1) == ch && Board[2].charAt(2) == ch) {
            isWin = true;
        }

        // 왼쪽 아래로 향하는 대각선
        if (Board[0].charAt(2) == ch && Board[1].charAt(1) == ch && Board[2].charAt(0) == ch) {
            isWin = true;
        }

        return isWin;
    }
}
