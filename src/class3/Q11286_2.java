package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11286_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int A = Math.abs(a);
                int B = Math.abs(b);

                if (A > B) {
                    return 1;
                }
                else if (A == B) {
                    return a - b;
                }
                else { //A < B
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                queue.offer(num);
            }
            else {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
