import java.io.*;
import java.util.*;

public class Main {
    static int m, n, h;
    static int[][][] box;      // -1(빈칸), 0(안익음), 1(익음)
    static int[][][] day;      // 익는 데 걸린 날(시작점 0일)
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1}; // 위/아래(층)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 열(M)
        n = Integer.parseInt(st.nextToken()); // 행(N)
        h = Integer.parseInt(st.nextToken()); // 높이(H)

        box = new int[h][n][m];
        day = new int[h][n][m];

        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 입력 및 초기화
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < m; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());
                    if (box[z][x][y] == 1) {
                        // 익은 토마토: 시작점(day=0)
                        q.add(new int[]{z, x, y});
                        day[z][x][y] = 0;
                    } else {
                        // 아직 안 익은 토마토: 미방문 표시(-1)
                        day[z][x][y] = -1;
                    }
                    // 빈칸(-1)은 day가 0이어도 상관없지만, 계산에서 무시합니다.
                }
            }
        }

        // 멀티 소스 BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cz = cur[0], cx = cur[1], cy = cur[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = cz + dz[dir];
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (box[nz][nx][ny] != 0) continue;       // 0(안 익음)만 익힐 수 있음
                if (day[nz][nx][ny] != -1) continue;      // 이미 방문(익은 날 설정됨)

                day[nz][nx][ny] = day[cz][cx][cy] + 1;    // 하루 뒤에 익음
                box[nz][nx][ny] = 1;                      // 익었다고 표기(선택)
                q.add(new int[]{nz, nx, ny});
            }
        }

        // 결과 계산
        int ans = 0;
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (box[z][x][y] == 0) { // 아직 안 익은 게 남아있다면 실패
                        System.out.println(-1);
                        return;
                    }
                    if (day[z][x][y] > ans) ans = day[z][x][y];
                }
            }
        }
        System.out.println(ans);
    }
}
