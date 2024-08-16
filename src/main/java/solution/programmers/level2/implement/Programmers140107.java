package solution.programmers.level2.implement;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 * 점 찍기
 */
public class Programmers140107 {
    public static void main(String[] args) {
        long solution = solution(10, 2);
        System.out.println("solution = " + solution);
    }

    public static long solution(long k, long d) {
        long answer = 0;

        for(long x = 0; x <= d; x += k){
            long maxY = (long) Math.sqrt(d*d - x*x);
            answer += maxY / k + 1;
        }

        return answer;
    }
}
