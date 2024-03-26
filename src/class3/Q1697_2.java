package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697_2 {
    public static int[] visit = new int[100001];
    public static int N;
    public static int K;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) System.out.println(0);
        else {
            System.out.println(distance(N));
        }
    }

    private static int distance(int n) {
        queue.offer(n);
        visit[n] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll(); //현재 위치
            int next = temp; //다음 위치

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    return visit[temp];
                }

                if (next >= 0 && next <= 100000 && visit[next] == 0) {
                    queue.add(next);
                    visit[next] = visit[temp] + 1;
                }
            }
        }
        return -1;
    }
}
