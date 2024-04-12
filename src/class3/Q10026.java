package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10026 {
    static char[][] arr;
    static boolean[][] normalVisit;
    static boolean[][] weaknessVisit;
    static Queue<Node> normalQ = new LinkedList<>();
    static Queue<Node> weaknessQ = new LinkedList<>();
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int normalCnt, weaknessCnt, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        normalVisit = new boolean[N][N];
        weaknessVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        normalCnt = 0;
        weaknessCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!normalVisit[i][j]) {
                    findNormal(i, j);
                }

                if (!weaknessVisit[i][j]) {
                    findWeakness(i, j);
                }
            }
        }

        System.out.println(normalCnt + " " + weaknessCnt);
    }

    private static void findWeakness(int i, int j) {
        weaknessCnt++;
        weaknessQ.offer(new Node(i, j));
        weaknessVisit[i][j] = true;

        while (!weaknessQ.isEmpty()) {
            Node node = weaknessQ.poll();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int newX = x + dirX[k];
                int newY = y + dirY[k];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N) {

                    if (arr[x][y] == 'R' || arr[x][y] == 'G') {

                        if ((arr[newX][newY] == 'R' || arr[newX][newY] == 'G') && !weaknessVisit[newX][newY]) {
                            weaknessQ.offer(new Node(newX, newY));
                            weaknessVisit[newX][newY] = true;
                        }
                    }
                    else { //'B'일 경우

                        if (arr[newX][newY] == 'B' && !weaknessVisit[newX][newY]) {
                            weaknessQ.offer(new Node(newX, newY));
                            weaknessVisit[newX][newY] = true;
                        }
                    }
                }
            }
        }

    }

    private static void findNormal(int i, int j) {
        normalCnt++;
        normalQ.offer(new Node(i, j));
        normalVisit[i][j] = true;

        while (!normalQ.isEmpty()) {
            Node node = normalQ.poll();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int newX = x + dirX[k];
                int newY = y + dirY[k];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N) {

                    if (arr[x][y] == arr[newX][newY] && !normalVisit[newX][newY]) {
                        normalQ.offer(new Node(newX, newY));
                        normalVisit[newX][newY] = true;
                    }
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
