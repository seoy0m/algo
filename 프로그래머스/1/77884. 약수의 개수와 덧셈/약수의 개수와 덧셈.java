class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i =left ; i<=right; i++){
            //제곱 수면 빼
            if(Math.sqrt(i)%1==0){
                answer-= i;
            }
            //아니면 더해
            else{
                answer+=i;
            }
            
            System.out.println(answer);
        }
        
        
        return answer;
    }
    
    
}