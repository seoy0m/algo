class Solution {
    
    static int[] fibo = new int[100000+1];
    
    
    public int solution(int n) {
        int[] fibo = new int[n+1];
        fibo[1] = 1;
        
        if(fibo[n]==0){
    
    for(int i =2; i<=n; i++){
            fibo[i]= (fibo[i-2]+fibo[i-1])%1234567;
        }
        }
        
        int answer = fibo[n];
        
        return answer;
    }
    
  
}