import java.util.*;

class Solution {
    
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited= new boolean[n][m];
        
        answer= bfs(new int[] {0,0,1}, visited, maps,n,m);
        return answer;
    }
    
    private int bfs(int[] start, boolean[][] visited, int[][] maps,int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]]=true;
        
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[0]==n-1&&curr[1]==m-1) return curr[2];
            
            for(int k=0; k<4; k++){
                int ni = curr[0]+di[k];
                int nj = curr[1]+dj[k];
                
                if(ni<0||ni>=n||nj<0||nj>=m||visited[ni][nj]||maps[ni][nj]==0) 
                    continue;
                
                q.add(new int[] {ni,nj,curr[2]+1});
                visited[ni][nj]=true;
            }
        }
        return -1;
    }
}