package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549 {
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

            int next = num * 2;
            if (next < arr.length && arr[next] == 0) {
                arr[next] = arr[num];
                queue.offer(next);
            }

            next = num - 1;
            if (next >= 0 && arr[next] == 0) {
                arr[next] = arr[num] + 1;
                queue.offer(next);
            }

            next = num + 1;
            if (next < arr.length && arr[next] == 0) {
                arr[next] = arr[num] + 1;
                queue.offer(next);
            }
        }
    }
}
