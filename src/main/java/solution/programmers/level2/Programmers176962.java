package solution.programmers.level2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * 과제 진행하기
 */
public class Programmers176962 {
    public static void main(String[] args) {
        String[] solution = solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparing(Task::getStartTime));
        Stack<Task> stoppedTasks = new Stack<>();

        for (String[] plan : plans) {
            tasks.add(new Task(plan[0], plan[1], Integer.parseInt(plan[2])));
        }

        Task now = tasks.poll();
        int time = now.startTime;
        while (!tasks.isEmpty()) {
            time += now.left;
            Task next = tasks.peek();

            // 다음 과목까지 완료 불가능
            if (time > next.startTime) {
                now.left = time - next.startTime;
                stoppedTasks.push(now);
            } else { // 다음 과목까지 여유가 있어서 완료 가능
                answer.add(now.subject);
                if (!stoppedTasks.isEmpty()) {
                    now = stoppedTasks.pop();
                    continue;
                }
            }

            now = tasks.poll();
            time = now.startTime;
        }

        // 마지막에 학습중이던 과목 추가
        answer.add(now.subject);

        // 중지된 과목들 추가
        while (!stoppedTasks.isEmpty()) {
            answer.add(stoppedTasks.pop().subject);
        }

        return answer.toArray(new String[0]);
    }

    static class Task {
        String subject;
        int startTime;
        int left;

        public int getStartTime() {
            return startTime;
        }

        public Task(String subject, String startTime, int left) {
            String[] split = startTime.split(":");
            int hour = Integer.parseInt(split[0]) * 60;
            int minute = Integer.parseInt(split[1]);

            this.subject = subject;
            this.startTime = hour + minute;
            this.left = left;
        }
    }
}
