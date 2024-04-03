package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q9375_2 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) { //테스트케이스
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<String, Integer>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken(); //옷이름 필요없음
                String kind = st.nextToken(); //옷종류

                if (map.containsKey(kind)) map.put(kind, map.get(kind) + 1);
                else map.put(kind, 1);
            }
            int result = 1;
            for (int k : map.values()) { //map의 value를 하나씩 가져온다
                result *= (k + 1); //null, 즉 입지 않은 것을 포함해야하므로 +1 해준다
            }

            sb.append(result - 1).append("\n"); //모두 null인 경우는 제외해야한다
        }
        System.out.println(sb);
    }
}
