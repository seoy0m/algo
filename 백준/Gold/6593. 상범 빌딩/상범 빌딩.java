import java.io.*;
import java.util.*;

public class Main {

    static int l, n, m, cnt;
    static char[][][] building;
    static int[][][] visited;

    static int[] dx ={1,-1,0,0,0,0};
    static int[] dy ={0,0,1,-1,0,0};
    static int[] dl ={0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      while (true) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          l = Integer.parseInt(st.nextToken());
          n = Integer.parseInt(st.nextToken());
          m = Integer.parseInt(st.nextToken());

          if (l==0 && n==0 && m==0) break;

          int[] end = {};
          building = new char[l][n][m];
          visited = new int[l][n][m];

          for (int i = 0; i < l; i++) {
              for (int j = 0; j < n; j++) {
                  String s = br.readLine();
                  for (int k = 0; k < m; k++) {
                      building[i][j][k] = s.charAt(k);

                      if (building[i][j][k] == '#') {
                          visited[i][j][k] = -1;
                      } else if (building[i][j][k] == 'E') {
                          end = new int[]{i, j, k};
                      }

                  }
              }
              br.readLine();
          }

          for (int i = 0; i < l; i++) {
              for (int j = 0; j < n; j++) {
                  for (int k = 0; k < m; k++) {
                      if (building[i][j][k] == 'S') bfs(new int[]{i, j, k, 0});
                  }
              }
          }

          if (visited[end[0]][end[1]][end[2]] != 0) {
              System.out.println("Escaped in " + cnt + " minute(s).");
          } else {
              System.out.println("Trapped!");
          }

      }

    };

    static void bfs(int[] start)  {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]][start[2]] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 6; k++) {
                int nx = cur[1] + dx[k];
                int ny = cur[2] + dy[k];
                int nl = cur[0] + dl[k];

                if (nx <0 || ny <0 || nl < 0 || nx>= n || ny>=m || nl>= l
                        ||building[nl][nx][ny]=='#' || visited[nl][nx][ny] > 0) continue;

                if (building[nl][nx][ny]== 'E') {
                    cnt= cur[3]+1;
                    visited[nl][nx][ny] = cnt;
                    break;
                }

                q.add(new int[] {nl,nx,ny,cur[3]+1});
                visited[nl][nx][ny] = cur[3]+1;

            }
        }
    }
}
