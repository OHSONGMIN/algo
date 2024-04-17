package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7662 { //우선순위 큐로 설정하면 poll() <-> offer() 반복해도 순서가 변화 없음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (str.equals("I")) pq.offer(num);
                else { // "D"일 때

                    if (pq.isEmpty()) continue;
                    else if (num == -1) pq.poll();
                    else { // num == 1

                        int k = pq.size() - 1;
                        while (k-- > 0) {
                            queue.offer(pq.poll());
                        }
                        pq.poll();

                        k = queue.size();
                        while (k-- > 0) {
                            pq.offer(queue.poll());
                        }
                    }
                }
            }

            if (pq.isEmpty()) sb.append("EMPTY").append("\n");
            else {
                int max = Integer.MIN_VALUE;
                int min = pq.poll();

                int j = pq.size() - 1;
                while (j-- > 0) {
                    pq.poll();
                }
                max = pq.poll();
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }
}
