package class1;

import java.util.Scanner;

public class Q8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트케이스 입력 받고
        //OX 결과를 String으로 받아오고
        //count = 0; sum = 0;
        int test = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test; i++) {
            int count = 0;
            int sum = 0;

            String str= sc.nextLine();

            for (int j = 0; j < str.length(); j++) { //str.length()-1 까지 반복

                if (str.charAt(j) == 'O') { //O 일 때 X 일 때 2가지 경우로 나눠도 충분하다
                    sum += ++count;
                } else {
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}