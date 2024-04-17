package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019 {
    static String[] arr;
    static boolean[] visit;
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            arr = new String[10000];
            visit = new boolean[10000];
            
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Arrays.fill(arr, "");
            bfs(a, b);
            sb.append(arr[b]).append("\n");
            queue.clear();
        }
        System.out.println(sb);
    }

    private static void bfs(int a, int b) {
        queue.offer(a); //현재
        visit[a] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == b) break;

            int dNum = D(num);
            int sNum = S(num);
            int lNum = L(num);
            int rNum = R(num);

            if (!visit[dNum]) {
                arr[dNum] = arr[num] + "D";
                queue.offer(dNum);
                visit[dNum] = true;
            };

            if (!visit[sNum]) {
                arr[sNum] = arr[num] + "S";
                queue.offer(sNum);
                visit[sNum] = true;
            };

            if (!visit[lNum]) {
                arr[lNum] = arr[num] + "L";
                queue.offer(lNum);
                visit[lNum] = true;
            };

            if (!visit[rNum]) {
                arr[rNum] = arr[num] + "R";
                queue.offer(rNum);
                visit[rNum] = true;
            };
        }
    }

    private static int R(int num) { //1234

        if (num != 0) {
            int a = num / 1000; //1000의자리
            int b = num / 100 % 10; //100의자리
            int c = num / 10 % 10; //10의자리
            int d = num % 10 ; //1의자리

            //4123
            return d * 1000 + a * 100 + b * 10 + c;
        }
        //num == 0
        return 0;
    }

    private static int L(int num) { //1234

        if (num != 0) {
            int a = num / 1000; //1000의자리
            int b = num / 100 % 10; //100의자리
            int c = num / 10 % 10; //10의자리
            int d = num % 10 ; //1의자리

            //2341
            return b * 1000 + c * 100 + d * 10 + a;
        }
        //num == 0
        return 0;
    }

    private static int S(int num) {
        if (num == 0) return 9999;
        return num -= 1;
    }

    private static int D(int num) {
        num *= 2; //두 배로 바꾼다.
        // 9999보다 큰 경우 10000으로 나눈 나머지를 취한다.
        if (num > 9999) num %= 10000;
        return num;
    }

}
