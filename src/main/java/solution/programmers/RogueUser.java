package solution.programmers;

import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064?language=java
 * 불량 사용자
 */
public class RogueUser {
    public static void main(String[] args) {
        String[] user_id_3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id_3 = {"fr*d*", "abc1**"};
        System.out.println(solution(user_id_3, banned_id_3));
    }

    private static boolean[] used;
    private static String[] userId;
    private static Pattern[] bannedId;
    private static HashSet<String> answer = new HashSet<>();
    private static int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = new Pattern[banned_id.length];
        used = new boolean[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            bannedId[i] = Pattern.compile(banned_id[i].replace("*", "[a-z0-9]"));
        }

        dfs(0, "");
        return answer.size();
    }

    private static void dfs(int idx, String user) {
        if (user.length() == bannedId.length) {
            answer.add(user);
        }

        for (int i = idx; i < userId.length; i++) {
            for (int j = 0; j < bannedId.length; j++) {
                if (!used[j] && bannedId[j].matcher(userId[i]).matches()) {
                    used[j] = true;
                    dfs(i + 1, user + i);
                    used[j] = false;
                }
            }
        }
    }
}

