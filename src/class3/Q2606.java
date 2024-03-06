package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2606 {
    static boolean[][] arr;
    static int[] virusCheck;
    static int node;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        arr = new boolean[node + 1][node + 1];
        virusCheck = new int[node + 1];

        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = true;
        }

        virusCheck[1] = 1;

        System.out.println(virusNode(1));
    }

    private static int virusNode(int start) {

        for (int i = 1; i < node + 1; i++) {
            if (arr[start][i] == true && virusCheck[i] == 0) {
                virusCheck[i] = 1;
                count++;
                virusNode(i);
            }
        }
        return count;
    }
}
