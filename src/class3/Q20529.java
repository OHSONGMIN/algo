package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20529 {
    static Map<Integer, String> map;
    public static void main(String[] args) throws IOException {
        // 16 * 16 데이터를 만들어두고
        // Map에 MBTI와 number를 넣고
        // 입력 들어오는 값에 해당하는 심리적인 거리를 계산후...
        // 다시 배열에 넣고 제일 작은 값 3개를 출력해랴...?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[16][16];
        map = new HashMap<>();
        map.put(0, "ISFP");
        map.put(1, "ISFJ");
        map.put(2, "ISTP");
        map.put(3, "ISTJ");
        map.put(4, "INFP");
        map.put(5, "INFJ");
        map.put(6, "INTP");
        map.put(7, "INTJ");
        map.put(8, "ESFP");
        map.put(9, "ESFJ");
        map.put(10, "ESTP");
        map.put(11, "ESTJ");
        map.put(12, "ENFP");
        map.put(13, "ENFJ");
        map.put(14, "ENTP");
        map.put(15, "ENTJ");

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {

                String strA = map.get(i);
                String strB = map.get(j);

                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    if (strA.charAt(k) != strB.charAt(k)) cnt++;
                }
                arr[i][j] = cnt;
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] inputArr = new int[N];

            for (int j = 0; j < N; j++) {
                inputArr[j] = find(st.nextToken());
            }

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N - 1; j++) {
                int inputA = inputArr[j];

                for (int k = j + 1; k < N; k++) {
                    int inputB = inputArr[k];

                    list.add(arr[inputA][inputB]);
                }
            }
            Collections.sort(list);
            int sum = 0;
            int cnt = 0;
            for (int num : list)  {
                sum += num;
                cnt++;

                if (cnt == 3) break;
            } //이 아니고~~~~~~~~~~~~~~~~~~~~~~~~
            //심리적인 거리가 가장 적을 세사람을 구한 다음.... 그 결과를 출력하는 것....

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(String s) {

        for (int k : map.keySet()) {
            if (map.get(k).equals(s)) {
                return k;
            }
        }
        return -1;
    }
}
