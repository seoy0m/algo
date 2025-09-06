import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static  int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int n,m;

    static int[] di ={ -1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int paint =0;

        for (int i=0; i<n;i++){
            for (int j =0; j<m; j++){
                if(!visited[i][j]&&arr[i][j]==1) {

                    int size = bfs(new int[] {i,j});
                    paint++;
                    if(size>max)
                        max=size;
                }

            }
        }

        System.out.println(paint);
        System.out.println(max);

    }//main

    static int bfs(int[] adr) {
        queue.add(adr);
        visited[adr[0]][adr[1]] = true;

        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int k = 0; k < 4; k++) {
                int newi = curr[0] + di[k];
                int newj = curr[1] + dj[k];

                if (newi < 0 || newi >= n || newj < 0 || newj >= m || visited[newi][newj] || arr[newi][newj] != 1)
                    continue;

                queue.add(new int[]{newi, newj});
                visited[newi][newj] = true;
                cnt++;
            }
        }
        return cnt;
    }

}