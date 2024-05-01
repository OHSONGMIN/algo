package class4;

import java.util.*;

public class Q13549_3 {
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
        queue.offer(start);
        arr[start] = 0; // 시작점의 시간은 0으로 설정

        while (!queue.isEmpty()) {
            int num = queue.poll();

            // 현재 위치에서 걷는 경우를 고려
            int[] nextPositions = {num - 1, num + 1, num * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next < arr.length && arr[next] == 0) {
                    if (next == num * 2) // 순간이동인 경우
                        arr[next] = arr[num]; // 시간은 그대로 유지
                    else // 걷는 경우
                        arr[next] = arr[num] + 1; // 시간이 1초 증가
                    queue.offer(next);
                }
            }

            // 동생을 찾았을 경우 종료
            if (num == K) {
                return;
            }
        }
    }
}