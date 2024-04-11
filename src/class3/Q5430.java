package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine(); //명령어
            int n = Integer.parseInt(br.readLine()); //배열의 크기

            String input = br.readLine(); //배열에 들어갈 데이터
            input = input.substring(1, input.length() - 1);

            st = new StringTokenizer(input, ",");
            Deque<Integer> dq = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                dq.offer(Integer.valueOf(st.nextToken()));
            }

            boolean reverse = false; //역방향 여부
            boolean error = false;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'R') {
                    reverse = !reverse;
                }
                else if (c == 'D') {

                    if (dq.isEmpty()) {
                        sb.append("error").append("\n");
                        error = true;
                        break;
                    }

                    if (reverse) {
                        dq.pollLast();
                    }
                    else {
                        dq.pollFirst();
                    }
                }
            }

            if(!error) {
                sb.append('[');
                if (!dq.isEmpty()) { //제일 마지막에 D가 나와서 dq가 비어있을 수도 있음
                    if (reverse) {
                        while (dq.size() > 1) {
                            sb.append(dq.pollLast()).append(',');
                        }
                        sb.append(dq.pollLast());
                    } else {
                        while (dq.size() > 1) {
                            sb.append(dq.pollFirst()).append(',');
                        }
                        sb.append(dq.pollFirst());
                    }
                }
                sb.append(']').append("\n");
            }
        }
        System.out.println(sb);
    }
}
