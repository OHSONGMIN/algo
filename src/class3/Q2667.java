package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static List<Integer> list = new ArrayList<>();
    static Queue<Node> queue = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) bfs(i, j);
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void bfs(int i, int j) {
        queue.offer(new Node(i, j));
        visit[i][j] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            count++;

            for (int k = 0; k < 4; k++) {
                int newX = x + dirX[k];
                int newY = y + dirY[k];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visit[newX][newY] && arr[newX][newY] != 0) {
                    queue.offer(new Node(newX, newY));
                    visit[newX][newY] = true;
                }
            }
        }

        list.add(count);
    }

    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

    }
}
