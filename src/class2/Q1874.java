package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        Stack st = new Stack<>();

        int k = 1; //1~N
        int j = 0; //arr의 index

        while (k <= N) {
            st.push(k);
            sb.append("+").append("\n");

            while (!st.isEmpty() && st.peek().equals(arr[j])) {
                st.pop();
                sb.append("-").append("\n");
                j++;
            }
            k++;
        }

        if (!st.isEmpty()) System.out.println("NO");
        else System.out.println(sb);
    }
}
