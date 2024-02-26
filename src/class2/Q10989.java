package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
/*Counting*/
        int[] arr = new int[10001]; //0~10000

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        StringBuilder sb = new StringBuilder();

        //1~10000
        for (int i = 1; i <= 10000; i++) {

            while (arr[i] > 0) {
                sb.append(i).append("\n");
                arr[i]--;
            }
        }

        System.out.println(sb);
/*Arrays.sort(arr)*/
        /*
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
         */
    }
}
