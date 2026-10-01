import java.util.Scanner;
import java.util.Stack;

public class Balanced_Brackets {
    public static String isBalance(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')){
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()){
            return "YES";
        }
        else {
            return "NO";
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng test case: ");
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++){
            System.out.println("test case " + i );
            String s = sc.nextLine();
            System.out.println(isBalance(s));
        }
        sc.close();
    }
}
