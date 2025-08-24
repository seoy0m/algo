import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int max =0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        int answer =0;

        for(int h =1 ; h <= max ; h++) {

            int cnt = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (!visited[i][j] && arr[i][j] > h) {
                        bfs(i,j,h);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer,cnt);

        }

        System.out.println(answer);

    }

    static void bfs(int i,int j,int h){
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0],y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + di[k],ny = cur[1] + dj[k];

                if( nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || arr[nx][ny] <= h) continue;

                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }


    }
}
