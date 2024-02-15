package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(queue.size() > 1) { //queue.size가 1보다 크다면(2개 이상의 값이라면)
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll()); //맨 앞에 있는 값을 꺼내서 맨 뒤에 추가
            } //그리고 K번째 값은 출력해서 sb에 담는다.
            sb.append(queue.poll()).append(", ");
        }
        //sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        //sb.delete(sb.length()-2, sb.length()); //sb.length()-2 ~ sb.length()-1 값을 삭제
        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}
