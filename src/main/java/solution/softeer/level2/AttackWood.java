package solution.softeer.level2;

import java.io.*;
import java.util.*;

public class AttackWood {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> enemy = new HashMap<>();
        Attack[] attack = new Attack[2];

        // 행마다 환경 파괴범 수 초기화
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    enemy.put(i, enemy.getOrDefault(Integer.valueOf(i), 0) + 1);
                }
            }
        }
        // 공격 초기화
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            attack[i] = new Attack(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int idx = 0; idx < attack.length; idx++) {
            for (int x = attack[idx].x1; x <= attack[idx].x2; x++) {
                Integer key = Integer.valueOf(x);
                if (enemy.get(key) != null && enemy.get(key) > 0) {
                    enemy.put(key, enemy.get(key) - 1);
                }
            }
        }

        int answer = 0;
        for (int value : enemy.values()) {
            answer += value;
        }

        System.out.println(answer);
    }

    static class Attack {
        int x1, x2;

        Attack(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}
