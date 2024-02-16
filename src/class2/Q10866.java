package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        Deque deque = new LinkedList();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();

            if (order.equals("push_front")) {
                deque.addFirst(st.nextToken());
            } else if (order.equals("push_back")) {
                deque.addLast(st.nextToken());
            } else if (order.equals("pop_front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            } else if (order.equals("pop_back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollLast()).append("\n");
            } else if (order.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (order.equals("empty")) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (order.equals("front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            } else if (order.equals("back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
