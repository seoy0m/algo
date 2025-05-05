class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total=0;
        for(int i =0; i<count; i++){
            total+= price*(i+1);
        }
        if(money< total){
        
            answer= total-money;
        }

        return answer;
    }
}