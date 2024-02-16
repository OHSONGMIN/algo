package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10828 {
    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();
/* 384ms */
            /*
            if (order.equals("push")) {
                stack.add(Integer.parseInt(st.nextToken()));

            } else if (order.equals("pop")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());

            } else if (order.equals("size")) {
                System.out.println(stack.size());

            } else if (order.equals("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);

            } else if (order.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }

            }
            */

/* 176ms */
            switch (order) {
                case "push" :
                    stack.push(st.nextToken());
                    break;

                case "pop" :
                    if (stack.isEmpty()) {
                        sb.append("-1").append("\n");
                        break;
                    } else {
                        sb.append(stack.pop()).append("\n");
                        break;
                    }

                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty" :
                    if (stack.isEmpty()) {
                        sb.append("1").append("\n");
                        break;
                    } else {
                        sb.append("0").append("\n");
                        break;
                    }

                case "top" :
                    if(stack.isEmpty()) {
                        sb.append("-1").append("\n");
                        break;
                    } else {
                        sb.append(stack.peek()).append("\n");
                        break;
                    }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
