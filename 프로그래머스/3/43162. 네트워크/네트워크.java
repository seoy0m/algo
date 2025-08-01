import java.util.*;

class Solution {

    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i =0 ; i< n ; i++){
            if(!visited[i]){
                bfs(i,n,visited,computers);
                answer++;
            }
                
            }
        return answer;
        }
        
        
    
    private void bfs(int start, int n, boolean[] visited,int[][] computers){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start]=true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int i =0; i<n;i++){
                if(computers[curr][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}