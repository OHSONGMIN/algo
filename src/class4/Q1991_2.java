package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991_2 {
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = null; //default를 null로 설정
            this.right = null; //default를 null로 설정
        }
    }
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        // tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[parentValue - 'A'] == null) { //부모 노드가 아직 생성되지 않은 경우
                tree[parentValue - 'A'] = new Node(parentValue, null, null);
            }

            if (leftValue != '.') { //왼쪽 자식이 있다면
                tree[leftValue - 'A'] = new Node(leftValue, null, null); //왼쪽 자식 노드 생성 후
                tree[parentValue - 'A'].left = tree[leftValue - 'A']; //부모 노드와 연결
            }

            if (rightValue != '.') { //오른쪽 자식이 있다면
                tree[rightValue - 'A'] = new Node(rightValue, null, null);
                tree[parentValue - 'A'].right = tree[rightValue - 'A']; //부모 노드와 연결
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
    }

    private static void preorder(Node node) {

        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {

        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node) {

        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}