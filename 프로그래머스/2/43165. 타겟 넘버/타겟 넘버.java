class Solution {  
    int answer = 0;  
  
    public int solution(int[] numbers, int target) {  
        dfs(0, numbers, target, 0);  
        return answer;  //타겟 넘버를 만드는 방법의 수
    }  
    
    private void dfs(int dep, int[] numbers, int target, int sum){
        
        if(dep==numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
        
    dfs(dep + 1,numbers,target,sum+numbers[dep]);//plus
    dfs(dep + 1,numbers,target,sum-numbers[dep]);//minus
    }
        
    
}
