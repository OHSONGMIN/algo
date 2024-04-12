package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
    static int[] dirZ = {0, 0, 0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0, 0, 0};
    static int[] dirX = {0, 0, -1, 1, 0, 0};
    static int[][][] arr; //z x y
    static int M, N, H;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];

        for (int i = 0; i < H; i++) {

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (num == 1) {
                        queue.offer(new Node(i, j, k));
                    }
                    arr[i][j][k] = num;
                }
            }
        }
        bfs();

        int max = 1;
        boolean check = true;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    max = Math.max(arr[i][j][k], max);

                    if (arr[i][j][k] == 0) check = false;
                }
            }
        }

        if (check) System.out.println(max - 1); //시작을 1로 설정했기 때문에
        else System.out.println(-1);
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int z = node.z;
            int y = node.y;
            int x = node.x;

            for (int i = 0; i < 6; i++) {
                int newZ = z + dirZ[i];
                int newY = y + dirY[i];
                int newX = x + dirX[i];

                if (newZ >= 0 && newZ < H && newY >= 0 && newY < N && newX >= 0 && newX < M) {

                    if (arr[newZ][newY][newX] == 0) {

                        arr[newZ][newY][newX]= arr[z][y][x] + 1;
                        queue.offer(new Node(newZ, newY, newX));
                    }
                }
            }
        }
    }

    static class Node {
        int z;
        int y;
        int x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
