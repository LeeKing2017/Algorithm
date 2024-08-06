package solution.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * 미로 찾기
 * 시간 초과
 */
public class Programmers159993V1 {
    public static void main(String[] args) {
        int solution1 = solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
        System.out.println("solution = " + solution1);
        int solution2 = solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"});
        System.out.println("solution = " + solution2);
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] isVisited;
    private static Node LEVER;
    private static Node START;
    private static Node END;
    private static final int BLOCKED = -1;
    public static int solution(String[] maps) {
        initValue(maps);
        int leverDistance = bfs(START, LEVER);
        initValue(maps);
        int leverToEndDistance = bfs(LEVER, END);

        return isAvailable(leverDistance, leverToEndDistance) ? leverDistance + leverToEndDistance : -1;
    }

    private static void initValue(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        isVisited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            String[] split = maps[i].split("");
            for (int j = 0; j < split.length; j++) {
                switch (split[j]) {
                    case "S" -> {
                        START = new Node(i, j);
                        map[i][j] = 0;
                    }
                    case "L" -> {
                        LEVER = new Node(i, j);
                        map[i][j] = 0;
                    }
                    case "E" -> {
                        END = new Node(i, j);
                        map[i][j] = 0;
                    }
                    case "O" -> {
                        map[i][j] = 0;
                    }
                    case "X" -> {
                        map[i][j] = BLOCKED;
                    }
                    default -> throw new IllegalArgumentException();
                }
            }
        }
    }

    private static int bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        isVisited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }

                if (!isVisited[nx][ny] && map[nx][ny] != BLOCKED) {
                    if (nx == end.x && ny == end.y) {
                        return map[now.x][now.y] + 1;
                    }

                    map[nx][ny] = map[now.x][now.y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return 0;
    }

    private static boolean isAvailable(int leverDistance, int leverToEndDistance) {
        return leverDistance != 0 && leverToEndDistance != 0;
    }

    public static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
