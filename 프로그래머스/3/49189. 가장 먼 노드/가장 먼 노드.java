import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0; i<=n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            int num1 = e[0];
            int num2 = e[1];
            
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }
        int[] answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        
        int maxD = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next]= true;
                    answer[next] =answer[cur]+1;
                    maxD = Math.max(maxD, answer[next]);
                    q.add(next);
                }
            }
        }
        
        int ans = 0;
        for(int d : answer){
            if(d == maxD){
                ans++;
            }
        }
        
        
        return ans;
    }
}