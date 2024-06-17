package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsAndBfs {
    static int node, line, start;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(bf.readLine());
            int firstIndex = Integer.parseInt(str.nextToken());
            int secondIndex = Integer.parseInt(str.nextToken());

            arr[firstIndex][secondIndex] = arr[secondIndex][firstIndex] = 1;
        }

        dfs(start);
        result.append("\n");
        check = new boolean[node+1];

        bfs(start);
        System.out.println(result);
    }

    static void dfs(int start) {
        check[start] = true;
        result.append(start).append(" ");

        for (int i = 0; i <= node ; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            Integer poll = q.poll();
            result.append(poll).append(" ");

            for (int i = 1; i <= node; i++) {
                if (arr[poll][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}