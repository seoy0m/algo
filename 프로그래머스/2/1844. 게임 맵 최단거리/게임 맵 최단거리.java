import java.util.*;

class Solution {
    static boolean[][] visited;
    
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    
    static int n, m;
    
    public int solution(int[][] maps) {
        int answer = -1;
       
        n = maps.length;
        m = maps[0].length;
        
         visited = new boolean[n][m];
        
        answer= bfs(0,0,1, maps);
        
        return answer;
    }
    
    public int bfs(int i, int j , int cnt, int[][] map){
        Queue<int[]> q = new LinkedList<>();
        visited[i][j]=true;
        q.add(new int[] {i,j,cnt});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int k =0 ; k<4 ; k++){
                int ni = cur[0]+di[k];
                int nj = cur[1]+dj[k];
                
                if(ni < 0 || ni >=n || nj <0 || nj >=m 
                   || visited[ni][nj] || map[ni][nj]==0) continue;
                
                if(ni == n-1 && nj == m-1) return cur[2]+1;
                
                visited[ni][nj]= true;
                q.add(new int[] {ni,nj,cur[2]+1});
                
            }
        }
        
        return -1;
        
    }
}