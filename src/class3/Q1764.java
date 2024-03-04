package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set set = new HashSet();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<String>();
        //array를 안쓴 이유... array의 크기를 처음에 정할 수 없었음

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (set.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);

        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.println(list.size());
        System.out.println(sb);
    }
}
