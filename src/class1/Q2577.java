package class1;

import java.util.Scanner;

public class Q2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt() * sc.nextInt() * sc.nextInt();

        String str = Integer.toString(num); //int를 String으로 바꾼다.

        for(int i = 0; i <= 9; i++) {
            int count = 0;
            for(int j = 0; j < str.length(); j++) { //str의 길이만큼
                if(str.charAt(j) -'0' == i) count++;
            }
            System.out.println(count);
        }
    }
}
