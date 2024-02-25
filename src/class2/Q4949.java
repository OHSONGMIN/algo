package class2;

import java.util.Scanner;
import java.util.Stack;

public class Q4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();

            if (s.equals(".")) {
                break;
            }

            System.out.println(isBalance(s));
        }

    }

    private static String isBalance(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[') {
                st.push(c);
            }

            else if (c == ')') {

                if (st.isEmpty() || (st.peek() != '(')) return "no";
                else st.pop();
            }

            else if (c ==']') {

                if (st.isEmpty() || (st.peek() != '[')) return "no";
                else st.pop();
            }
        }
        if (st.isEmpty()) return "yes";
        else return "no";
    }
}
