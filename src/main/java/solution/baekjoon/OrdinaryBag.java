package solution.baekjoon;

import java.util.*;
import java.io.*;

public class OrdinaryBag {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tw = Integer.parseInt(st.nextToken());
        Item[] items = new Item[n + 1];
        int[][] dp = new int[tw + 1][n + 1];
        items[0] = new Item(0, 0);

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // bw = 가방 무게, i = 물건 순서
        for (int bw = 1; bw <= tw; bw++) {
            for (int i = 1; i <= n; i++) {
                Item nowItem = items[i];
                dp[bw][i] = items[i].w > bw
                        ? dp[bw][i - 1]
                        : Math.max(dp[bw][i - 1], nowItem.p + dp[bw - nowItem.w][i - 1]);
            }
        }

        System.out.print(dp[tw][n]);
    }

    static class Item {
        int w, p;

        Item(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }
}
