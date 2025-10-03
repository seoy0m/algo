import java.util.*;

class Solution {
    static boolean[][] visited;
    static char[][] arr;
    static int ans;
    
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++){
            visited= new boolean[5][5];
            arr= new char[5][5];
            ans=0;
            String[] s = places[i];
            
            for(int a=0; a<5; a++){
                for(int b =0; b<5; b++){
                    arr[a][b]= s[a].charAt(b);
                }
            }
            
            for(int a=0; a<5; a++){
                for(int b =0; b<5; b++){
                    if(arr[a][b]=='P'){
                        bfs(a,b,1);
                    }
                    if(ans!=0) break;
                }
            }
            
            answer[i]= (ans==0) ? 1: 0 ;
            
        }
        return answer;
    }
    
    static void bfs(int x, int y, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y,cnt});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[2]>2) break;
            
            for(int k=0; k<4;k++){
                int nx = cur[0]+di[k];
                int ny = cur[1]+dj[k];
                
                if(nx<0 || nx>=5 || ny<0 || ny>=5 
                   || arr[nx][ny]=='X'|| visited[nx][ny]) continue;
                
                if(arr[nx][ny]=='P' && cur[2]<=2) {
                    ans++;
                    break; 
                }
                
                q.add(new int[] {nx,ny,cur[2]+1});
                visited[nx][ny]=true;
            }
            
        }
    }
}