import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
           String string = br.readLine();
           Stack<Character> stack = new Stack<>();


           for (int j = 0; j < string.length(); j++) {
               char ch = string.charAt(j);
               if (ch == '(') {
                   stack.push(ch);
               } else if (ch == ')') {
                   if (stack.isEmpty()) {
                       stack.push(ch);
                       break;
                   }
                   stack.pop();
               }
           }

           if (stack.isEmpty()) {
               System.out.println("YES");
           } else {
               System.out.println("NO");
           }

        }
    }
}