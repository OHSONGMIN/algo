package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21736 { //너비우선탐색
    static String[][] arr;
    static boolean[][] visit;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int count, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        visit = new boolean[N][M];

        int pointX = 0;
        int pointY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                String s = String.valueOf(str.charAt(j));
                arr[i][j] = s;

                if (s.equals("I")) {
                    pointX = i;
                    pointY = j;
                }
            }
        }
        find(pointX, pointY);

        if (count == 0) System.out.println("TT");
        else System.out.println(count);
    }

    private static void find(int pointX, int pointY) {
        count = 0;
        visit[pointX][pointY] = true;
        queue.offer(new Node(pointX, pointY));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeX = node.x;
            int nodeY = node.y;

            for (int i = 0; i < 4; i++) {
                int newX = nodeX + dirX[i];
                int newY = nodeY + dirY[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M && !arr[newX][newY].equals("X") && !visit[newX][newY]) {
                    queue.offer(new Node(newX, newY));
                    visit[newX][newY] = true;

                    if (arr[newX][newY].equals("P")) count++;
                }
            }
        }
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
