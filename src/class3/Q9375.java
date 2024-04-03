package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q9375 {
    public static Map<String, Integer> map = new HashMap<String, Integer>();
    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            map.clear();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷 이름은 필요없음
                String str = st.nextToken(); // 옷 종류

                if (map.containsKey(str)) map.put(str, map.get(str) + 1);
                else map.put(str, 1);

            }

            int result = 1;

            for (int k : map.values()) {
                result = result * (k + 1);
            }
            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);
    }

}
