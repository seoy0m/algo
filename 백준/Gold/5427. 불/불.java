import java.io.*;
import java.util.*;

public class Main {

    static int h, w, ans;
    static char[][] arr;
    static int[][] fire;   // 불 도착 시각(최초), 없으면 -1
    static int[][] dist;   // 사람 도착 시각(최초), 없으면 -1

    static Queue<int[]> fq; // fire queue
    static Queue<int[]> q;  // human queue

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr  = new char[h][w];
            fire = new int[h][w];
            dist = new int[h][w];
            fq   = new LinkedList<>();
            q    = new LinkedList<>();
            ans  = -1;

            for (int i = 0; i < h; i++) {
                Arrays.fill(fire[i], -1);
                Arrays.fill(dist[i], -1);
            }

            int sx = -1, sy = -1;

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = s.charAt(j);

                    if (arr[i][j] == '*') {
                        fire[i][j] = 0;
                        fq.add(new int[]{i, j});
                    } else if (arr[i][j] == '@') {
                        sx = i; sy = j;
                    }
                }
            }

            // 불 BFS: 각 칸의 불 도착 '최초 시각' 계산
            while (!fq.isEmpty()) {
                int[] cur = fq.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (arr[nx][ny] == '#') continue;       // 벽은 불도 못 감
                    if (fire[nx][ny] != -1) continue;       // 이미 불 시각 있음

                    fire[nx][ny] = fire[cur[0]][cur[1]] + 1;
                    fq.add(new int[]{nx, ny});
                }
            }

            // 사람 시작 셋업
            dist[sx][sy] = 0;
            q.add(new int[]{sx, sy});

            // 시작이 가장자리면 즉시 1분
            if (sx == 0 || sy == 0 || sx == h - 1 || sy == w - 1) {
                sb.append(1).append('\n');
                continue;
            }

            // 사람 BFS
            out:
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int t = dist[cur[0]][cur[1]];

                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    // 격자 밖으로 나가면 탈출 성공
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        ans = t + 1;
                        break out;
                    }

                    if (arr[nx][ny] == '#') continue;       // 벽
                    if (dist[nx][ny] != -1) continue;       // 이미 방문

                    int nt = t + 1;
                    // 불이 같은 시각 또는 더 이르게 오는 칸이면 못 감
                    if (fire[nx][ny] != -1 && fire[nx][ny] <= nt) continue;

                    dist[nx][ny] = nt;
                    q.add(new int[]{nx, ny});
                }
            }

            if (ans == -1) sb.append("IMPOSSIBLE").append('\n');
            else sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
