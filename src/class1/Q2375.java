package class1;

import java.util.Scanner;

public class Q2375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();

        for (int i = 1; i <= total; i++) {
            int rep = sc.nextInt();
            String str = sc.next();

            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < rep; k++) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();

        }

    }
}
//package class1;
//
//import java.util.Scanner;
//
//public class Q2375 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int total = Integer.parseInt(sc.nextLine());
//
//        //1. 입력받을문자열이 몇개인지 먼저 찍고
//        //2. for문 돌려서 처음 건 숫자 배열에 두번째는 문자 배열에 담는다
//        //3. 하나씩 꺼내서 또 돌린다
//        int[] repp = new int[total];
//        String[] strr = new String[total];
//
//        for (int i = 0; i < total; i++) {
//            int rep = Integer.parseInt(sc.nextLine());
//            repp[i] = rep;
//
//            String str = sc.nextLine();
//            strr[i] = str;
//
//        }
//
//        //배열에 담긴 것들 출력
//        for (int i = 0; i < total; i++) {
//            String str = strr[i];
//            for (int j = 0; j < str.length(); j++) {
//                for (int k = 0; k <= repp[i]; k++ ) {
//                    System.out.print(str.charAt(j));
//                }
//            }
//            System.out.println();
//        }
//    }
//}
