package class2;

import java.io.*;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = M; i <= N; i++) {
            if (isDecimal(i) == 0) bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int isDecimal(int i) {
        if (i == 1) return -1;
        if (i == 2) return 0;

        int count = 0;
        for (int j = 2; j < i; j++) {
            if(i % j == 0) count++;
        }
        return count;
    }
}
