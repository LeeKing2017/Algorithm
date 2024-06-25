package solution.book;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] solution = solution("110010101001");
        System.out.println("solution = " + Arrays.toString(solution));
    }
    static int changeCnt, zeroCnt;

    public static int[] solution(String s) {
        String changeResult = s;
        while (!changeResult.equals("1")) {
            changeResult = change(changeResult);
        }

        int[] answer = new int[2];
        answer[0] = changeCnt;
        answer[1] = zeroCnt;
        return answer;
    }

    public static String change(String s) {
        int oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCnt++;
            }
        }
        zeroCnt += s.length() - oneCnt;
        changeCnt++;
        return Integer.toBinaryString(oneCnt);
    }
}
