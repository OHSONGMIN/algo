package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1389 { //visit 필요없음....
    static int[][] cntArr;
    static boolean[][] arr;
    static int N, M, min;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cntArr = new int[N+1][N+1];
        arr = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = true;
        }

        min = -1;
        for (int i = 1; i < N+1; i++) {
            find(i);
        }

    }

    private static void find(int i) {
        queue.clear();
        //i를 queue에 넣고...?
        int count = 0;
        while (!queue.isEmpty()) {
            int x = 1; //queue에서 가져온다고 가정
            count++;


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
