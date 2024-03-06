package class3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11723_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int bitset = 0; //공집합

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int num;

            switch (str) {
                case "add" : //add 다음에 오는 값이 3이라면 0, 1, [2]번째 원소를 추가해야함. 따라서 -1 해준다.
                    num = Integer.parseInt(st.nextToken()) -1;
                    bitset = bitset | (1 << num);
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken()) -1;
                    bitset = bitset & ~(1 << num);
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken()) -1;
                    if ((bitset & (1<< num)) == (1 << num)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken()) -1;
                    bitset = bitset ^ (1 << num);
                    break;
                case "all" :
                    bitset = (1 << 20) -1;
                    break;
                case "empty" :
                    bitset = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
