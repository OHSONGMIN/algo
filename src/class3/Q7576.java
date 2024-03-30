package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
    public static int[][] arr;
    //public static int[][] visit;
    public static int[] dirX = {0, 0, -1, 1};
    public static int[] dirY = {-1, 1, 0, 0};
    public static Queue<Node> queue = new LinkedList<Node>();
    public static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //상자의 가로칸
        N = Integer.parseInt(st.nextToken()); //상자의 세로칸

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) queue.add(new Node(i, j));
            }
        }

        bfs();

        if (checkZero()) { //0이 있으면 -1 출력
            System.out.println(-1);
        } else { //없으면 최대값 - 1 출력
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }
            System.out.println(max - 1);
        }
    }

    private static boolean checkZero() { //0이 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) return true;
            }
        }
        return false;
    }


    private static void bfs() { //너비우선탐색

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX >= N || newX < 0 || newY >= M || newY < 0) continue; //아무 활동도 하지 않고 다시 처음으로

                if (arr[newX][newY] == 0) {
                    arr[newX][newY] = arr[x][y] + 1; //-1은 갈 수 없는 곳, 0 외의 숫자는 한번 들른 곳
                    queue.add(new Node(newX, newY));
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
