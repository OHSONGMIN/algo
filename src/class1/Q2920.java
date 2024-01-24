package class1;

import java.util.Scanner;

public class Q2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트케이스 입력 받고
        //OX 결과를 배열에 담고
        //count = 0;
        //배열의 첫번째가 O라면 count가 1 X라면 count는 그대로 0
        int test = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test; i++) {
            int count = 0;
            int sum = 0;

            //String result = sc.nextLine();
            char[] num = sc.nextLine().toCharArray();

            if(num[0] == 'O') {
                count = 1;
                sum += count;
            }

            for (int j = 1; j < num.length; j++) {

                if(num[j-1]=='O' && num[j]=='O') {
                    count++;
                    sum += count;
                } else if(num[j-1]=='X' && num[j]=='O') {
                    count = 1;
                    sum += count;
                } else {
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
