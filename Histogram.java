import java.util.*;

public class Histogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < heights.length) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i);
                i++;
            } else {
                int top = st.pop();
                int area = heights[top] * (st.isEmpty() ? i : i - st.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            int area = heights[top] * (st.isEmpty() ? i : i - st.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the numbers");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(largestRectangleArea(arr));
        maxArea(arr);
    }
}
