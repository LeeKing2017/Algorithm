package solution.programmers.level2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * 광물 캐기
 */
public class Programmers172927 {
    public static void main(String[] args) {
//        int solution1 = solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"});
        int solution2 = solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
//        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }

    private static final String DIA = "diamond";
    private static final String IR = "iron";
    private static final String ST = "stone";
    private static final int MAX_TOOL_AVAILABILITY = 5;

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        PriorityQueue<MineralSet> mineralQ = new PriorityQueue<>(Comparator.comparing(MineralSet::getTotalCount).reversed());
        Queue<String> tools = new LinkedList<>();

        // tools 큐에 다이아 곡갱이부터 추가
        initTools(picks, tools);

        // MineralQ에 5개씩 다이아가 많은 순서대로 추가
        initMinerSet(minerals, mineralQ);
        System.out.println("mineralQ = " + mineralQ);

        while (!mineralQ.isEmpty() && !tools.isEmpty()) {
            MineralSet mineralSet = mineralQ.poll();
            String tool = tools.poll();
            answer += mineralSet.getFatigue(tool);
        }

        return answer;
    }

    private static void initTools(int[] picks, Queue<String> tools) {
        for (int i = 0; i < 3; i++) {
            int toolCnt = picks[i];
            String tool = getTool(i);
            while (toolCnt != 0) {
                tools.add(tool);
                toolCnt--;
            }
        }
    }

    private static String getTool(int i) {
        return switch (i) {
            case 0 -> DIA;
            case 1 -> IR;
            case 2 -> ST;
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }

//    private static void initMinerSet(String[] minerals, int[] picks, PriorityQueue<MineralSet> mineralQ) {
//        int index = 0;
//        int toolCount = picks[0] + picks[1] + picks[2];
//        while(toolCount-- > 0 && index < minerals.length){
//            MineralSet mineralSet = new MineralSet();
//
//            int limit = Math.min(index + 5, minerals.length);
//            for(int i=index;i<limit;i++){
//                switch (minerals[i]) {
//                    case DIA -> mineralSet.diaCount++;
//                    case IR -> mineralSet.ironCount++;
//                    case ST -> mineralSet.stoneCount++;
//                }
//            }
//
//            index = index+5;
//            mineralQ.add(mineralSet);//
//        }
//    }

    private static void initMinerSet(String[] minerals, PriorityQueue<MineralSet> mineralQ) {
        int maxIdx = minerals.length / MAX_TOOL_AVAILABILITY;
        int startRange = 0;
        int endRange = MAX_TOOL_AVAILABILITY;
        for (int i = 0; i <= maxIdx; i++) {
            String[] copy = Arrays.copyOfRange(minerals, startRange, endRange);
            MineralSet mineralSet = new MineralSet();
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] != null) {
                    switch (copy[j]) {
                        case DIA -> mineralSet.diaCount++;
                        case IR -> mineralSet.ironCount++;
                        case ST -> mineralSet.stoneCount++;
                    }
                }
            }

            mineralQ.add(mineralSet);
            startRange += MAX_TOOL_AVAILABILITY;
            endRange += MAX_TOOL_AVAILABILITY;
        }
    }

    static class MineralSet {
        private final static int HIGH = 25;
        private final static int MEDIUM = 5;
        private final static int LOW = 1;
        int diaCount;
        int ironCount;
        int stoneCount;

        public MineralSet() {
        }

        public int getTotalCount() {
            return (diaCount * HIGH) + (ironCount * MEDIUM) + (stoneCount * LOW);
        }

        public int getFatigue(String tool) {
            switch (tool) {
                case DIA -> {
                    return diaCount + ironCount + stoneCount;
                }
                case IR -> {
                    return (diaCount * MEDIUM) + ironCount + stoneCount;
                }
                case ST -> {
                    return (diaCount * HIGH) + (ironCount * MEDIUM) + stoneCount;
                }
                default -> throw new IllegalArgumentException("호완 가능한 곡갱이가 아닙니다");
            }
        }
    }
}
