import java.util.*;
import java.io.*;
import java.lang.*;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static class info {
        int height, diameter, hd;
        Node root;

        public info(Node node, int hd) {
            this.root = node;
            this.hd = hd;
        }
    }

    static class Binarytree {
        public static Node buildTree(int nodes[]) {
            int idx = 0;
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void display(Node node) {
            if (node == null) {
                return;
            }
            String str = "";
            str += node.left == null ? "." : node.left.data;
            str += " <- " + node.data + " -> ";
            str += node.right == null ? "." : node.right.data;
            System.out.println(str);
            display(node.left);
            display(node.right);
        }

        public static int size(Node node) {
            if (node == null) {
                return 0;
            }
            int leftSize = size(node.left);
            int rightSize = size(node.right);
            return leftSize + rightSize + 1;
        }

        public static void preOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public static void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }

        public static void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }

        public static int height(Node node) {
            if (node == null) {
                return -1;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static void levelOrder(Node node) {
            if (node == null) {
                return;
            }
            java.util.Queue<Node> q = new java.util.LinkedList<>();
            q.add(node);
            q.add(null);
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int left = count(root.left);
            int right = count(root.right);
            return left + right + 1;
        }

        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            return left + right + root.data;
        }

        public static int max(Node root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            int left = max(root.left);
            int right = max(root.right);
            return Math.max(root.data, Math.max(left, right));
        }

        public static int min(Node root) {
            if (root == null) {
                return Integer.MAX_VALUE;
            }
            int left = min(root.left);
            int right = min(root.right);
            return Math.min(root.data, Math.min(left, right));
        }

        public static boolean find(Node root, int data) {
            if (root == null) {
                return false;
            }
            if (root.data == data) {
                return true;
            }
            boolean left = find(root.left, data);
            boolean right = find(root.right, data);
            return left || right;
        }

        public static int diameterOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            int leftDia = diameterOfTree(root.left);
            int rightDia = diameterOfTree(root.right);
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int currDia = leftHeight + rightHeight + 2;
            return Math.max(currDia, Math.max(leftDia, rightDia));
        }

        public static info diameter(Node root) {
            if (root == null) {
                info base = new info(root, 0);
                base.height = -1;
                base.diameter = 0;
                return base;
            }
            info left = diameter(root.left);
            info right = diameter(root.right);
            info curr = new info(root, 0);
            curr.height = Math.max(left.height, right.height) + 1;
            int leftDia = left.diameter;
            int rightDia = right.diameter;
            int currDia = left.height + right.height + 2;
            curr.diameter = Math.max(currDia, Math.max(leftDia, rightDia));
            return curr;
        }

        public static boolean isBalanced(Node root) {
            if (root == null) {
                return true;
            }
            boolean leftBal = isBalanced(root.left);
            boolean rightBal = isBalanced(root.right);
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int currHeight = Math.abs(leftHeight - rightHeight);
            return leftBal && rightBal && currHeight <= 1;
        }

        public static boolean isSubTree(Node root, Node subRoot) {
            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                boolean left = isSubTree(root.left, subRoot.left);
                boolean right = isSubTree(root.right, subRoot.right);
                return left && right;
            }
            boolean left = isSubTree(root.left, subRoot);
            boolean right = isSubTree(root.right, subRoot);
            return left || right;
        }

        public static boolean isIdentical(Node root, Node subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (root.data != subRoot.data) {
                return false;
            }
            boolean left = isIdentical(root.left, subRoot.left);
            boolean right = isIdentical(root.right, subRoot.right);
            return left && right;
        }

        public static boolean isMirror(Node root, Node subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (root.data != subRoot.data) {
                return false;
            }
            boolean left = isMirror(root.left, subRoot.right);
            boolean right = isMirror(root.right, subRoot.left);
            return left && right;
        }

        public static boolean isSymmetric(Node root) {
            return isMirror(root, root);
        }

        public static boolean isFoldable(Node root) {
            if (root == null) {
                return true;
            }
            return isMirror(root.left, root.right);
        }

        public static void printSingleChild(Node root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right != null) {
                System.out.print(root.right.data + " ");
            }
            if (root.left != null && root.right == null) {
                System.out.print(root.left.data + " ");
            }
            printSingleChild(root.left);
            printSingleChild(root.right);
        }

        // horizontal distance
        public static int hd(Node root) {
            if (root == null) {
                return 0;
            }
            int left = hd(root.left);
            int right = hd(root.right);
            return left - right;
        }

        public static void topView(Node root) {
            java.util.Queue<info> q = new java.util.LinkedList<>();
            java.util.HashMap<Integer, Node> map = new java.util.HashMap<>();
            int min, max = 0;
            q.add(new info(root, 0));
            q.add = null;
            while (!q.isEmpty()) {
                info curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left != null) {
                        q.add(new info(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new info(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                    for (int i = min; i <= max; i++) {
                        System.out.print(map.get(i).data + " ");
                    }
                }
            }
        }

        public static void bottomView(Node root) {
            java.util.Queue<info> q = new java.util.LinkedList<>();
            java.util.HashMap<Integer, Node> map = new java.util.HashMap<>();
            int min, max = 0;
            q.add(new info(root, 0));
            q.add = null;
            while (!q.isEmpty()) {
                info curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    map.put(curr.hd, curr.node);
                    if (curr.node.left != null) {
                        q.add(new info(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new info(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        public static void kthLevel(Node root, int k) {
            if (root == null) {
                return;
            }
            if (k == 0) {
                System.out.print(root.data + " ");
            }
            kthLevel(root.left, k - 1);
            kthLevel(root.right, k - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // menu driven program
        int n = sc.nextInt();
        int nodes[] = new int[n];
        System.out.println("Enter the nodes of the tree: " + "(-1 for null nodes)");
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextInt();
        }
        System.out.println("Enter your choice: ");
        System.out.println("1 for size of the tree");
        System.out.println("2 for preOrder traversal");
        System.out.println("3 for inOrder traversal");
        System.out.println("4 for postOrder traversal");
        System.out.println("5 for levelOrder traversal");
        System.out.println("6 for height of the tree");
        System.out.println("7 for count of the nodes");
        System.out.println("8 for sum of the nodes");
        System.out.println("9 for max of the nodes");
        System.out.println("10 for min of the nodes");
        System.out.println("11 for finding a node");
        System.out.println("12 for diameter of the tree");
        System.out.println("13 for mirror of the tree");
        System.out.println("14 for checking if the tree is balanced");
        System.out.println("15 for printing single child nodes");
        System.out.println("16 for printing top view");
        System.out.println("17 for printing bottom view");
        System.out.println("18 for printing kth level");
        System.out.println("19 for printing all the paths from root to leaf");
        System.out.println("20 for printing all the paths from root to leaf with target sum");
        int choice = sc.nextInt();
        Node root = Node.buildTree(nodes);
        switch (choice) {
            case 1: {
                System.out.println(Node.size(root));
                break;
            }
            case 2: {
                Node.preOrder(root);
                break;
            }
            case 3: {
                Node.inOrder(root);
                break;
            }
            case 4: {
                Node.postOrder(root);
                break;
            }
            case 5: {
                Node.levelOrder(root);
                break;
            }
            case 6: {
                System.out.println(Node.height(root));
                break;
            }
            case 7: {
                System.out.println(Node.count(root));
                break;
            }
            case 8: {
                System.out.println(Node.sum(root));
                break;
            }
            case 9: {
                System.out.println(Node.max(root));
                break;
            }
            case 10: {
                System.out.println(Node.min(root));
                break;
            }
            case 11: {
                int data = sc.nextInt();
                System.out.println(Node.find(root, data));
                break;
            }
            case 12: {
                System.out.println(Node.diameterOfTree(root));
                break;
            }
            case 13: {
                Node.mirror(root);
                Node.levelOrder(root);
                break;
            }
            case 14: {
                System.out.println(Node.isBalanced(root));
                break;
            }
            case 15: {
                Node.printSingleChildNodes(root);
                break;
            }
            case 16: {
                Node.topView(root);
                break;
            }
            case 17: {
                Node.bottomView(root);
                break;
            }
            case 18: {
                int k = sc.nextInt();
                Node.kthLevel(root, k);
                break;
            }
            case 19: {
                Node.printAllPaths(root, "");
                break;
            }
            case 20: {
                int target = sc.nextInt();
                Node.printAllPathsTargetSum(root, "", target);
                break;
            }
        }
    }
}