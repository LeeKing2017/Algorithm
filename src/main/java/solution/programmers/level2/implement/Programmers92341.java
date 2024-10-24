package solution.programmers.level2.implement;

import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 주차 요금 계산
 * 사람의 인지 능력이 아닌 프로그래밍적으로 생각하자!
 */
public class Programmers92341 {
    public static void main(String[] args) {
//        int[] solution = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        int[] solution = solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
        System.out.println(Arrays.toString(solution));
    }

    static final String IN = "IN";
    static final String OUT = "OUT";
    static final String LAST_OUT_TIME = "23:59";
    static boolean[] check;
    static int[] FEES;
    static String[] RECORDS;
    static final HashMap<String, Integer> carParkTime = new LinkedHashMap<>();
    public static int[] solution(int[] fees, String[] records) {
        FEES = fees;
        RECORDS = records;
        check = new boolean[records.length];

        for(int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");

            if (check[i]) {
                continue;
            }

            if (info[2].equals(IN)) {
                check[i] = true;
                int inTime = convertToMinutes(info[0]);
                int outTime = convertToMinutes(LAST_OUT_TIME);

                // 출차 시간 찾기
                if (i != records.length - 1) {
                    for (int j = i + 1; j < records.length; j++) {
                        if (check[j]) {
                            continue;
                        }

                        String[] sp = records[j].split(" ");

                        if (sp[1].equals(info[1]) && sp[2].equals(OUT)) {
                            outTime = convertToMinutes(sp[0]);
                            check[j] = true;
                            break;
                        }
                    }
                }
                int parkTime = outTime - inTime;
                carParkTime.put(info[1], carParkTime.getOrDefault(info[1], 0) + parkTime);
            }
        }

        int[] answer = new int[carParkTime.size()];
        int idx = 0;

        List<String> carNums = new ArrayList<>(carParkTime.keySet());
        carNums.sort(String::compareTo);

        for (String carNum : carNums) {
            answer[idx++] = findFee(carParkTime.get(carNum));
        }

        return answer;
    }

    private static int findFee(int parkTime) {
        int fee = 0;

        if (parkTime < FEES[0]) {
            return FEES[1];
        }

        // 기본금 정산
        fee += FEES[1];
        // 추가 시간 정산
        int extraTime = parkTime - FEES[0];
        if (extraTime >= 0) {
            fee += FEES[3] * (extraTime / FEES[2]);

            if(extraTime % FEES[2] != 0) {
                fee += FEES[3];
            }
        }

        return fee;
    }

    private static int convertToMinutes(String timeSt) {
        String[] time = timeSt.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        return hours * 60 + minutes;
    }
}