package class2;

import java.util.Scanner;

public class Q2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int card = sc.nextInt();
        int num = sc.nextInt();

        int[] arr = new int[card];
        for(int i = 0; i < card; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;
        for(int i = 0; i < card - 2; i++) {
            for(int j = i + 1; j < card - 1; j++) {
                for(int k = j + 1; k < card; k++) {

                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum > num) {
                        continue;
                    } else if (sum == result) {
                        result = sum;
                        break;
                    } else if (sum > result) {
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
