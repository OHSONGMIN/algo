package class1;

import java.util.Scanner;

public class Q1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String result = "";

        while(sc.hasNext()) {
            String str = sc.nextLine();
            String result = "yes";

            if (str.equals("0")) break;

            //str.length()가 3이라면 첫번째 숫자까지 반복
            //str.length()가 4라면 두번째 숫자까지 반복
            for (int i = 0; i < (str.length()/2); i++) {
                if (str.charAt(i) != str.charAt(str.length() - (i+1))) {
                    result = "no";
                    break;
                }
            }
            System.out.println(result);
        }

    }
}
