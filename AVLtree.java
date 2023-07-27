import java.util.*;
import java.lang.*;

public class AVLtree {
    static class Node {
        int data;
        Node left, right;
        int height;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    static Node root;

    public static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return (height(root.left) - height(root.right));
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // perform rotation
        y.left = x;
        x.right = T2;

        // update height
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // update height
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root;

        // update root height
        root.height = 1 + max(height(root.left), height(root.right));

        // get root's balance factor
        int bf = getBalance(root);

        // left left case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // right right case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // left right case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // right left case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void display(Node root) {
        if (root == null) {
            return;
        }
        String str = "";
        str += root.left == null ? "." : root.left.data;
        str += " <- " + root.data + " -> ";
        str += root.right == null ? "." : root.right.data;
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create a AVL Tree ->");
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter the nodes: ");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        System.out.println("Preorder traversal of the constructed AVL tree is: ");
        preorder(root);
        System.out.println();
        System.out.println("Display Of AVL Tree");
        display(root);
        sc.close();
    }
}
