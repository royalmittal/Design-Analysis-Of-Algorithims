import java.util.*;

public class BTnBST {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            this.left = this.right = null;
        }

        static ArrayList<Integer> inorder = new ArrayList<>();

        static class Pair {
            Node node;
            int state;

            Pair(Node node, int state) {
                this.node = node;
                this.state = state;
            }
        }

        static class Info {
            int size, min, max, height;
            boolean isBST;

            public Info(int s, int mn, int mx, int h, boolean isbst) {
                this.size = s;
                this.min = mn;
                this.max = mx;
                this.height = h;
                this.isBST = isbst;
            }
        }

        public static Node Insert(Node root, int val) {
            if (root == null) {
                return new Node(val);
            }
            if (val < root.data) {
                root.left = Insert(root.left, val);
            } else if (val > root.data) {
                root.right = Insert(root.right, val);
            }
            return root;
        }

        public static Info LargestBST(Node root) {
            if (root == null) {
                return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, -1, true);
            }
            Info leftInfo = LargestBST(root.left);
            Info rightInfo = LargestBST(root.right);
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
            boolean isBST = leftInfo.isBST && rightInfo.isBST
                    && (root.data > leftInfo.max && root.data < rightInfo.min);
            if (isBST) {
                return new Info(size, min, max, height, true);
            } else {
                return new Info(Math.max(leftInfo.size, rightInfo.size), min, max, height, false);
            }
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

        public static void getInorder(Node root, ArrayList<Integer> inorder) {
            if (root == null) {
                return;
            }
            getInorder(root.left, inorder);
            inorder.add(root.data);
            getInorder(root.right, inorder);
        }

        private static Node createBST(ArrayList<Integer> inorder, int st, int end) {
            if (st > end) {
                return null;
            }
            int mid = (st + end) / 2;
            Node root = new Node(inorder.get(mid));
            root.left = createBST(inorder, st, mid - 1);
            root.right = createBST(inorder, mid + 1, end);
            return root;
        }

        public static Node mergeBSTs(Node root1, Node root2) {
            ArrayList<Integer> inorder1 = new ArrayList<>();
            ArrayList<Integer> inorder2 = new ArrayList<>();
            getInorder(root1, inorder1);
            getInorder(root2, inorder2);
            ArrayList<Integer> inorder = new ArrayList<>();
            int i = 0, j = 0;
            while (i < inorder1.size() && j < inorder2.size()) {
                if (inorder1.get(i) < inorder2.get(j)) {
                    inorder.add(inorder1.get(i));
                    i++;
                } else {
                    inorder.add(inorder2.get(j));
                    j++;
                }
            }
            while (i < inorder1.size()) {
                inorder.add(inorder1.get(i));
                i++;
            }
            while (j < inorder2.size()) {
                inorder.add(inorder2.get(j));
                j++;
            }
            return createBST(inorder, 0, inorder.size() - 1);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(25);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
        root.right = new Node(75);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);
        root.right.right.left = new Node(80);

        Node.Info res = Node.LargestBST(root);
        System.out.println("Size: " + res.size);
        System.out.println("Min: " + res.min);
        System.out.println("Max: " + res.max);
        System.out.println("Height: " + res.height);
        System.out.println("IsBST: " + res.isBST);

        Node.display(root);

        System.out.println("Merge BSTs");
        System.out.println("Enter the number of keys for BST1");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the Keys for Insertion");
        int val[] = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
            root = Node.Insert(root, val[i]);
        }
        Node.display(root);
        System.out.println("Enter the number of keys for BST2");
        n = sc.nextInt();
        System.out.println("Enter the Keys for Insertion");
        int val2[] = new int[n];
        for (int i = 0; i < n; i++) {
            val2[i] = sc.nextInt();
            root = Node.Insert(root, val2[i]);
        }
        Node.display(root);
        Node root1 = Node.createBST(Node.inorder, 0, Node.inorder.size() - 1);
        Node.display(root1);

    }
}
