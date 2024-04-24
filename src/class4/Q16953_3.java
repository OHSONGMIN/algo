package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16953_3 {
    static long A, B;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();

        bfs(A);
    }

    private static void bfs(long a) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(a);
        cnt = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long num = queue.poll();

                if (num > B) continue;
                else if (num == B) {
                    System.out.println(cnt);
                    return;
                }
                else { //num < B
                    queue.offer(num * 2);
                    queue.offer(num * 10 + 1);
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }
}
