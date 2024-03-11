package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int x;
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());

            if (x == 0 && priorityQueue.isEmpty()) {
                sb.append(0).append("\n");
            }
            else if (x == 0 && !priorityQueue.isEmpty()) {
                sb.append(priorityQueue.poll()).append("\n");
            }
            else {
                priorityQueue.add(x);
            }
        }

        System.out.println(sb);

    }
}
