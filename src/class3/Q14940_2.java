package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14940_2 {
    public static int[] dirX = {0, 0, 1, -1};
    public static int[] dirY = {1, -1, 0, 0};
    public static int N;
    public static int M;
    public static int[][] arr; //원본 배열
    public static boolean[][] visit; //원본 배열
    public static int[][] result; //최종 결과
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int pointX = 0;
        int pointY = 0;

        arr = new int[N][M];
        visit = new boolean[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    pointX = i;
                    pointY = j;
                }
            }
        }

        result[pointX][pointY] = 0;
        visit[pointX][pointY] = true;
        shortDis(pointX, pointY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && visit[i][j] == false) result[i][j] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void shortDis(int i, int j) {

        queue.offer(new Node(i, j));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int newX = node.x + dirX[k];
                int newY = node.y + dirY[k];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M && arr[newX][newY] != 0 && visit[newX][newY] == false) {
                    queue.offer(new Node(newX, newY));
                    result[newX][newY] = result[node.x][node.y] + 1;
                    visit[newX][newY] = true;
                }
            }

        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
