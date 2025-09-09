import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] ans;
    static boolean[][] visited;
    static int n,m,a;
    static Queue<int[]> q = new LinkedList<>();

    static int[] di ={-1,1,0,0};
    static int[] dj ={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited =new boolean[n][m];
        

        for(int k =0 ; k<a;k++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1= Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i =y1; i< y2; i++){
                for(int j = x1; j<x2;j++){
                    arr[i][j]+=1;
                }
            }
        }

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i =0; i<n; i++){
            for (int j =0; j<m; j++){
                if(!visited[i][j] && arr[i][j]==0){

                    int mm = bfs(new int[]{i,j});
                    cnt++;
                    stack.add(mm);
                }
            }
        }

        ans= new int[cnt];
        
        for (int i=0; i<cnt;i++){
            ans[i]=stack.pop();
        }

        Arrays.sort(ans);

        System.out.println(cnt);
        for (int i=0;i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }//main

    static int bfs(int[] adr){

        q.add(adr);
        visited[adr[0]][adr[1]]= true;
        int cnt = 1;

        while (!q.isEmpty()){
            int[] curr = q.poll();

            for (int k =0; k<4;k++){

                int ni = curr[0]+di[k];
                int nj = curr[1]+dj[k];

                if(ni<0||ni>=n||nj<0||nj>=m||visited[ni][nj]||arr[ni][nj]!=0)
                    continue;

                q.add(new int[] {ni,nj});
                visited[ni][nj] = true;
                cnt++;
            }

        }
        return cnt;
    }
}