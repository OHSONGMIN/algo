package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue queue = new LinkedList();

        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine(), " ");
             String order = st.nextToken();

             switch (order) {
                 case "push" :
                     queue.add(st.nextToken());
                     break;

                 case "pop" :
                     if (queue.isEmpty()) {
                         sb.append("-1").append("\n");
                         break;
                     } else {
                         sb.append(queue.poll()).append("\n");
                         break;
                     }

                 case "size" :
                     sb.append(queue.size()).append("\n");
                     break;

                 case "empty" :
                     if (queue.isEmpty()) {
                         sb.append("1").append("\n");
                         break;
                     } else {
                         sb.append("0").append("\n");
                         break;
                     }

                 case "front" :
                     if (queue.isEmpty()) {
                         sb.append("-1").append("\n");
                         break;
                     } else {
                         sb.append(queue.peek()).append("\n");;
                         break;
                     }

                 case "back" :
                     if (queue.isEmpty()) {
                         sb.append("-1").append("\n");
                         break;
                     } else {
                         for (int j = 1; j < queue.size(); j++) {
                             queue.add(queue.poll());
                         }
                         sb.append(queue.peek()).append("\n");
                         queue.add(queue.poll());
                         break;
                     }
             }
        }

        System.out.println(sb);

    }
}
