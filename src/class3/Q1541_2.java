package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541_2 { //split() 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-"); //-를 기준으로 배열에 넣기

        int total = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {

                String[] plusArray = arr[i].split("\\+");

                for (String s : plusArray) {
                    total += Integer.parseInt(s);
                }
            }
            else {

                String[] minusArray = arr[i].split("\\+");

                int sum = 0;
                for (String s : minusArray) {
                    sum += Integer.parseInt(s);
                }

                total -= sum;
            }
        }
        System.out.println(total);
    }
}
