import java.util.*;

public class StockSpan {
    public static void stockSpan(int stock[],int span[]){
        Stack <Integer> s = new Stack<>();
        int i;
        span[0]=1;
        s.push(0);
        for(i=1;i<stock.length;i++){
            while(!s.isEmpty() && currPrice>stock[s.peek()]){
                s.pop();
            }
        }
            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                int prevHighest = s.peek();
                span[i]=i-prevHighest;
            }
            s.push(i);
    }

    public static void main(String[] args) {

        int days = sc.nextInt();
        int stock[] = new int[days];
        for (int i = 0; i < days; i++) {
            stock[i] = sc.nextInt();
        }
        int span[] = new int[days];
        stockSpan(stock, span);
        for (int i = 0; i < days; i++) {
            System.out.println(span[i]);
        }
    }
}
