package solution.programmers.level2.implement;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 마법의 엘레베이터
 */
public class Programmer148653 {
    public static void main(String[] args) {
        int solution1 = solution(16);
        System.out.println("solution1 = " + solution1);
        int solution2 = solution(2554);
        System.out.println("solution2 = " + solution2);
    }

    public static int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int remain = storey % 10;
            storey /= 10;

            if (remain == 5) {
                int peek = storey % 10;
                if (peek >= 5) {
                    storey++;
                    answer += 5;
                } else {
                    answer += remain;
                }
            } else if (remain > 5) {
                storey++;
                answer += (10 - remain);
            } else {
                answer += remain;
            }
        }

        return answer;
    }
}
