import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();




        while (true) {
            String str = br.readLine();

            if(str.equals(".")) break;
            
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

//                System.out.println(Arrays.toString(stack.toArray()));

                if (c == '('){
                    stack.push(c);
                }
                else if (c == ')'){
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }else {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }

                }
                else if (c == '['){
                    stack.push(c);
                }
                else if (c == ']'){
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }else {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) flag = false;

            if(flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}