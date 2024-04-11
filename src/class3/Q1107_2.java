package class3;

import java.io.IOException;
import java.util.Scanner;

public class Q1107_2 {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if (M > 0) {

            for (int i = 0; i < M; i++) {
                broken[sc.nextInt()] = true; //true <- 고장남
            }
        }

        int min = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            //찾는 채널 번호가 최대 50000까지 나올 수 있고
            //무한대의 채널까지 가능하다고 하지만
            //9외의 모든 버튼이 고장났다고 가정했을 때의 999999 이상의 값이 필요하진 않을 것이다.
            String str = String.valueOf(i);
            boolean check = true;

            for (int j = 0; j < str.length(); j++) {

                if (broken[str.charAt(j) - '0']) {
                    //고장난 번호가 있다면
                    check = false;
                    break;
                }
            }

            if (check) { //고장난 번호가 없으면
                min = Math.min(min, str.length() + Math.abs(N - i));
            }
        }
        System.out.println(min);
    }
}
