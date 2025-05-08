class Solution {  
    int answer = 0;  
  
    public int solution(int[] numbers, int target) {  
        dfs(0, numbers, target, 0);  
        return answer;  
    }  
    
    private void dfs(int dep, int[] numbers, int target, int sum){
        if(dep==numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
    dfs(dep + 1,numbers,target,sum+numbers[dep]);
    dfs(dep + 1,numbers,target,sum-numbers[dep]);
    }
        
    
}
