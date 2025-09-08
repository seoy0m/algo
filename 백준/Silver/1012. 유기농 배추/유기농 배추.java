import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t= Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc=0; tc<t; tc++){
            st= new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visited = new boolean[n][m];

            for(int i=0; i<k ; i++){
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y =Integer.parseInt(st.nextToken());

                arr[y][x]=1;
            }

            int cnt =0;
            for (int i =0; i<n; i++){
                for (int j =0; j<m; j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        bfs(new int[] {i,j});
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int[] now){
        Queue<int[]> q = new LinkedList<>();
        q.add(now);
        visited[now[0]][now[1]]=true;

        while (!q.isEmpty()){
            int[] curr= q.poll();

            for (int k =0; k<4; k++){
                int ni = curr[0]+di[k];
                int nj = curr[1]+dj[k];

                if(ni<0 || ni>=n || nj <0 || nj>=m || arr[ni][nj]==0 || visited[ni][nj]) continue;

                q.add(new int[] {ni,nj});
                visited[ni][nj]=true;
            }
        }
    }
}