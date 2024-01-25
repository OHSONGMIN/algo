package class1;

import java.util.Scanner;

public class Q10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        //97~122
        for (int i = 97; i <= 122; i++) {
            int num = input.indexOf((char)i);
            System.out.print(num + " ");
            //더 간단하게 System.out.println(input.indexOf((char)i));
        }

        /* 원래 코드 */
        /*
        for (int i = 97; i <= 122; i++) {
            int num = -1;
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == (char)i) {
                    num = j;
                    break;
                }
            }
            System.out.print(num + " ");
        } */
    }
}
