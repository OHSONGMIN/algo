package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q7662_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // "I" 일 때 map에 삽입
                if (s.equals("I")) { //map에 num이 있으면 map.get(num)+1, num이 없으면 0+1
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else if (map.isEmpty()){ // "D" 인데 map이 비어있다면
                    continue;
                }
                else { // "D" 일 때
                    //num == 1이라면 map의 최댓값을, num != 1이라면 map의 최솟값을 가져온다.
                    int key = num == 1? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);

                    if (cnt == 1) { //map에 1개 있다면 remove
                        map.remove(key);
                    }
                    else { //2개 이상 있다면 value-1
                        map.put(key, cnt - 1);
                    }
                }
            }

            if (map.size() == 0) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
