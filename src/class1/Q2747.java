package class1;

import java.util.Scanner;

public class Q2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr= new int[num+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[num]);
    }
/*시간 초과*/
    /*
    public static int F(int f) {
        if (f==0) return 0;
        if (f==1) return 1;
        return F(f-1) + F(f-2);
    }
    */
}
