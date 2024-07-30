package solution.baekjoon;

import java.util.*;
import java.io.*;

public class BlueRay {
    static int lecture, blueRay;
    static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        lecture = Integer.parseInt(st.nextToken());
        blueRay = Integer.parseInt(st.nextToken());
        times = new int[lecture];
        int left = 1;
        int right = 1;
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0;i < lecture; i++) {
            times[i] = Integer.parseInt(str.nextToken());
            left = Math.max(left, times[i]);
            right += times[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (getBlueRayCount(mid) > blueRay) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    private static int getBlueRayCount(int blueRaySize) {
        int timeSum = 0, count = 0;
        for(int i = 0;i < lecture; i++) {
            if(timeSum + times[i] > blueRaySize) {
                timeSum = 0;
                count++;
            }
            timeSum += times[i];
        }

        if (timeSum != 0) {
            count++;
        }

        return count;
    }
}