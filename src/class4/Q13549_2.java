package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549_2 {
    static int[] arr;
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[200001];

        bfs(N);
        System.out.println(arr[K] - 1);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 1;
        arr[N] = time;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == K) {
                return;
            }

            int db = num * 2;
            while (db < arr.length && arr[db] == 0) {
                arr[db] = arr[num];
                queue.offer(db);
                db *= 2;
            }

            int[] nextPosition = {-1, 1};
            for (int i : nextPosition) {
                int next = num + i;

                if (next >= 0 && next < arr.length && arr[next] == 0) {
                    arr[next] = arr[num] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
