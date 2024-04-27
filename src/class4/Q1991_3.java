package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991_3 {

    static class Node {
        char value;
        Node leftValue;
        Node rightValue;

        public Node(char value, Node leftValue, Node rightValue) {
            this.value = value;
            this.leftValue = null;
            this.rightValue = null;
        }
    }

    static Node[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[value - 'A'] == null) tree[value - 'A'] = new Node(value, null, null);

            if (leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue, null, null);
                tree[value - 'A'].leftValue = tree[leftValue - 'A'];
            }

            if (rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue, null, null);
                tree[value - 'A'].rightValue = tree[rightValue - 'A'];
            }
        }

        preorder(tree[0]); //전위
        System.out.println();

        inorder(tree[0]); //중위
        System.out.println();

        postorder(tree[0]); //후위
    }
    private static void preorder(Node node) {

        if (node == null) return;
        System.out.print(node.value);
        preorder(node.leftValue);
        preorder(node.rightValue);
    }

    private static void inorder(Node node) {

        if (node == null) return;
        inorder(node.leftValue);
        System.out.print(node.value);
        inorder(node.rightValue);
    }

    private static void postorder(Node node) {

        if (node == null) return;
        postorder(node.leftValue);
        postorder(node.rightValue);
        System.out.print(node.value);
    }

}
