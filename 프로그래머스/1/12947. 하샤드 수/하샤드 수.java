class Solution {
    public boolean solution(int x) {
        String str = x+"";
        int n= 0;
        for(int i =0; i<str.length(); i++){
            n+= str.charAt(i)-'0';
        }
        
        
        boolean answer = true;
        
        if(x%n!=0){
            answer=false;
        }
        
        return answer;
    }
}