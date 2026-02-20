import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            } else if(s.charAt(i)==')' && !stack.isEmpty()){
                stack.pop();
            } else if(s.charAt(i)==')' && stack.isEmpty()){
                return false;
            }
        }
        answer = stack.isEmpty() ? true : false;
        

        return answer;
    }
}