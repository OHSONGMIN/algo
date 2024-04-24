package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16953 { //메모리 초과!!
    static int[] arr;
    static int A, B;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        arr = new int[B+1];

        bfs(A);

        if (arr[B] == 0) System.out.println(-1);
        else System.out.println(arr[B]);

    }

    private static void bfs(int a) {

        arr[a] = 1;
        queue.offer(a);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == B) {
                return;
            }

            int temp = num * 2;
            if (temp <= B) {

                if (arr[temp] == 0) { //계산된 적 없다는 뜻
                    arr[temp] = arr[num] + 1;
                    queue.offer(temp);
                }
            }

            temp = num * 10 + 1;
            if (temp <= B) {

                if (arr[temp] == 0) {
                    arr[temp] = arr[num] + 1;
                    queue.offer(temp);
                }
            }
        }
    }
}
