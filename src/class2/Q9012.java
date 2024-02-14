package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append(IsVps(br.readLine())).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    /* 방법2 - stack을 이용하자 */
    private static String IsVps(String s) {
        Stack<Character> stack = new Stack<>(); //Stack 생성

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // ( 일 땐 무조건 push
            if (c == '(') stack.push('(');
            else if (stack.empty()) return "NO"; // ) 일 때 stack이 비어있다면 "NO"
            else stack.pop(); // ) 일 때 stack에 ( 가 있다면 pop
        }
        
        //모든 작업을 끝낸 후
        if (stack.empty()) return "YES";
        else return "NO"; //stack에 ( 가 남아있다면

    }

    /* 방법 1 - 내가 나름대로 풀었음 */
    private static String VpsCheck(String s) {
        int count = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') count++;
            if (arr[i] == ')') count--;

            if (count < 0) return "NO";
        }

        if (count == 0) return "YES";
        else return "NO";
    }
}

