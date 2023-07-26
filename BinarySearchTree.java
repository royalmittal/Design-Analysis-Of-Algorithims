import java.util.*;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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

    public static Node Insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + "->");
        inorder(root.right);
    }

    public static Boolean Search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return Search(root.left, key);
        } else {
            return Search(root.right, key);
        }
    }

    public static Node Inordersuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node Delete(Node root, int del) {
        if (root.data < del) {
            root.right = Delete(root.right, del);
        } else if (root.data > del) {
            root.left = Delete(root.left, del);
        } else {
            // 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // 2 - single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;

            }
            // 3 - both children
            Node temp = Inordersuccessor(root.right);
            root.data = temp.data;
            root.right = Delete(root.right, temp.data);
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> Path) {
        for (int i = 0; i < Path.size(); i++) {
            System.out.println(Path.get(i) + "->");
        }
        System.out.println("NULL");
    }

    public static void PrintRootToLeaf(Node root, ArrayList<Integer> Path) {
        if (root == null) {
            return;
        }
        Path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(Path);
        }
        PrintRootToLeaf(root.left, Path);
        PrintRootToLeaf(root.right, Path);
        Path.remove(Path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node Min, Node Max) {
        if (root == null) {
            return true;
        }
        if (Min != null && root.data <= Min.data) {
            return false;
        }
        if (Max != null && root.data >= Max.data) {
            return false;
        }
        return isValidBST(root.left, Min, root) && isValidBST(root.right, root, Max);
    }

    public static Node CreateMirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftSubtree = CreateMirror(root.left);
        Node rightSubtree = CreateMirror(root.right);
        root.left = rightSubtree;
        root.right = leftSubtree;
        return root;
    }

    public static Node createBST(int arr[], int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
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

    public static Node BalancedBSt(Node root) {
        // inorder sequence of BST is sorted
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // sorted inorder array balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.println("Menu Driven Program for BST");
        System.out.println("1 - Insertion");
        System.out.println("2 - Deletion");
        System.out.println("3 - Searching");
        System.out.println("4 - Inorder Traversal");
        System.out.println("5 - Range For Printing");
        System.out.println("6 - Root to Leaf Printing");
        System.out.println("7 - Validation of BST");
        System.out.println("8 - Mirror of BST");
        System.out.println("9 - Create BST from Sorted Array");
        System.out.println("10 - Create Balanced BST from Unbalanced BST");
        System.out.println("11 - Display BST");
        System.out.println("0 - Exit");
        while (true) {
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of keys");
                    int n = sc.nextInt();
                    System.out.println("Enter the Keys for Insertion");
                    int val[] = new int[n];
                    for (int i = 0; i < n; i++) {
                        val[i] = sc.nextInt();
                        root = Insert(root, val[i]);
                    }
                    break;
                case 2:
                    System.out.println("Enter A Value for Deletion");
                    int del = sc.nextInt();
                    root = Delete(root, del);
                    System.out.println("BST After Deletion");
                    inorder(root);
                    break;
                case 3:
                    System.out.println("Enter A Key for Searching ");
                    int key = sc.nextInt();
                    if (Search(root, key)) {
                        System.out.println("Founded");
                    } else {
                        System.out.println("Not Founded");
                    }
                    break;
                case 4:
                    System.out.println("Your Keys Are ->");
                    inorder(root);
                    break;
                case 5:
                    System.out.println("Enter The range of Printing");
                    int k1 = sc.nextInt();
                    int k2 = sc.nextInt();
                    printInRange(root, k1, k2);
                    break;
                case 6:
                    ArrayList<Integer> Path = new ArrayList<>();
                    PrintRootToLeaf(root, Path);
                    break;
                case 7:
                    if (isValidBST(root, null, null)) {
                        System.out.println("Valid BST");
                    } else {
                        System.out.println("Not Valid BST");
                    }
                    break;
                case 8:
                    root = CreateMirror(root);
                    System.out.println("Mirror of BST");
                    inorder(root);
                    break;
                case 9:
                    System.out.println("Enter the size of array");
                    int size = sc.nextInt();
                    int arr[] = new int[size];
                    System.out.println("Enter the elements of array");
                    for (int i = 0; i < size; i++) {
                        arr[i] = sc.nextInt();
                    }
                    root = createBST(arr, 0, size - 1);
                    System.out.println("BST Created");
                    inorder(root);
                    break;
                case 10:
                    root = BalancedBSt(root);
                    System.out.println("Balanced BST");
                    inorder(root);
                    break;
                case 11:
                    System.out.println("Your BST");
                    display(root);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}