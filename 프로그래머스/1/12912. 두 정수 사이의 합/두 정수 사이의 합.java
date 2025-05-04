class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int min, max;
        if(a<=b){
            min=a;
            max=b;
        } else{
            min=b;
            max=a;
        }
        for(int i =min; i<=max; i++){
            answer+= i;
        }
        return answer;
    }
}