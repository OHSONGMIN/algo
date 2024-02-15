package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11050 {
    /* 메모이제이션을 이용하는 방법 */
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][K+1];

        int answer = memoization(N, K);
        System.out.println(answer);
    }

    private static int memoization(int n, int k) {

        if (arr[n][k] > 0) return arr[n][k];

        if (n == k || k == 0) return 1;

        //2차원 배열에 값 저장 후 return
        arr[n][k] = memoization(n-1, k-1) + memoization(n-1, k);
        return arr[n][k];
    }


    /* 재귀함수를 이용하는 방법 - 124ms */
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int answer = pascal(N, K);
        System.out.println(answer);
    }

    private static int pascal(int n, int k) {
        if (n == k || k == 0) return 1;

        return pascal(n-1, k-1) + pascal(n-1, k);
    }
    */

    /* 이항계수 공식을 이용하는 방법 : f(N) / (f(N-K) * f(k)) - 124ms */
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = factorial(N) / (factorial(N-K) * factorial(K));

        System.out.println(answer);
    }

    private static int factorial(int num) {
        if (num == 0) return 1; //num - 1을 하면 0이 나올 때가 있는데 이때 1로 return 해줘야함

        return num * factorial(num - 1);
    }
    */

}
