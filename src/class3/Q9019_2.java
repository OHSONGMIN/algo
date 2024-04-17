package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            String[] arr = new String[10000];
            boolean[] visit = new boolean[10000];

            queue.offer(a);
            visit[a] = true;
            Arrays.fill(arr, "");

            while (!queue.isEmpty()) {
                int num = queue.poll();

                if (num == b) break;

                int D = (num * 2) % 10000;
                int S = num == 0 ? 9999 : num - 1;
                int L = (num % 1000) * 10 + num / 1000;
                int R = (num / 10) + (num % 10) * 1000;

                if(!visit[D]) {
                    queue.offer(D);
                    visit[D] = true;
                    arr[D] = arr[num] + "D";
                }

                if(!visit[S]) {
                    queue.offer(S);
                    visit[S] = true;
                    arr[S] = arr[num] + "S";
                }

                if(!visit[L]) {
                    queue.offer(L);
                    visit[L] = true;
                    arr[L] = arr[num] + "L";
                }

                if(!visit[R]) {
                    queue.offer(R);
                    visit[R] = true;
                    arr[R] = arr[num] + "R";
                }
            }
            sb.append(arr[b]).append("\n");
        }
        System.out.println(sb);
    }
}
