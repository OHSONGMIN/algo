package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11279 {
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); //최대힙은 Comparator.reverseOrder 해줘야 함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int input = Integer.parseInt(br.readLine());

            if (input == 0 && priorityQueue.isEmpty()) {
                sb.append(0).append("\n");
            }
            else if (input == 0) {
                sb.append(priorityQueue.poll()).append("\n");
            }
            else {
                priorityQueue.offer(input);
            }
        }

        System.out.println(sb);
    }
}
