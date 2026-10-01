import java.util.Scanner;
import java.util.Stack;

public class Queue_using_Two_Stacks {
    public static void main(String[] args){
        Stack<Integer> Enqueue = new Stack<>();
        Stack<Integer> Dequeue = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++){
            int type = sc.nextInt();
            if (type == 1){
                int x = sc.nextInt();
                Enqueue.push(x);
            }
            else{
                if (Dequeue.isEmpty()){
                    while (!Enqueue.isEmpty()){
                        Dequeue.push(Enqueue.pop());
                    }
                }
                if (type == 2){
                    Dequeue.pop();
                }
                else if (type == 3){
                    System.out.println(Dequeue.peek());
                }
            }
        }
        sc.close();
    }
}
