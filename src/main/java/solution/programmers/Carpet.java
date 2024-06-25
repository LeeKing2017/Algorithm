package solution.programmers;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int[] solution = solution(10, 2);

        System.out.println("solution = " + Arrays.toString(solution));
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        int totalTiles = brown + yellow;

        for (int i = totalTiles; i >= 3; i--) {
            int width = i - 2;
            int height = totalTiles - width;

            if (height * width == totalTiles) {
                answer = new int[]{width, height};
                break;
            }
        }

        return answer;
    }
}
