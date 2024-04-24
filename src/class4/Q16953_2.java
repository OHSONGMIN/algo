package class4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16953_2 { //메모리 초과!!
    static char[] arr;
    static int A, B;
    static Queue<Character> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        arr = new char[B+1];

        Arrays.fill(arr, '0');

        bfs(A);

        if (arr[B] == '0') System.out.println(-1);
        else System.out.println(arr[B] - '0');

    }

    private static void bfs(int a) {

        arr[a] = '1';
        queue.offer((char) a);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == B) {
                return;
            }

            int temp = num * 2;
            if (temp <= B) {

                if (arr[temp] == '0') { //계산된 적 없다는 뜻
                    arr[temp] = (char) (arr[num] + 1);
                    //System.out.println("(char) (arr[num] + 1)의 결과는 " + (char) (arr[num] + 1)); //char 1은 int 49
                    queue.offer((char) temp);
                }
            }

            temp = num * 10 + 1;
            if (temp <= B) {

                if (arr[temp] == '0') {
                    arr[temp] = (char) (arr[num] + 1);
                    queue.offer((char) temp);
                }
            }
        }
    }
}
