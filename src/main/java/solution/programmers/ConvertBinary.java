package solution.programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * 이진 변환 반복하기
 */
public class ConvertBinary {
    public static void main(String[] args) {
        int[] solution = solution("110010101001");
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(String s) {
        int convertCnt = 0, zeroResultCnt = 0;
        while(!s.equals("1")) {
            int zeroCnt = 0;
            int len = s.length();
            for (int i = 0; i< len; i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                }
            }

            s = Integer.toBinaryString(len - zeroCnt);
            convertCnt++;
            zeroResultCnt += zeroCnt;
        }

        return new int[]{convertCnt, zeroResultCnt};
    }
}
