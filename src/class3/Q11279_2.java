package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11279_2 { //만약에 배열에 넣고 매번 정렬한다면?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                //배열의 마지막 값을 가져오는 것이 어려움....
                //0이 아닌 최댓값을 출력한다고 해도
                //배열이 비어있다면 (값이 모두 0이라면)
                //0을 출력해야하지만...
                //그렇다면 0이 아닌 최댓값을 출력하라고 할 수 없지 않나......

            }
        }
    }
}
