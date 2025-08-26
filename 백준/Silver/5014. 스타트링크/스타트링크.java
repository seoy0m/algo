import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 총 층수
        s = Integer.parseInt(st.nextToken()); // 현재 층
        g = Integer.parseInt(st.nextToken()); // 목적지 층
        u = Integer.parseInt(st.nextToken()); // 위로 이동
        d = Integer.parseInt(st.nextToken()); // 아래로 이동

        int res = bfs();
        if (res == -1) System.out.println("use the stairs");
        else System.out.println(res);
    }

    static int bfs() {
        int[] dist = new int[f + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == g) return dist[cur];

            // 위로 이동
            int up = cur + u;
            if (u > 0 && up <= f && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                q.add(up);
            }

            // 아래로 이동
            int down = cur - d;
            if (d > 0 && down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                q.add(down);
            }
        }
        return -1; // 도달 불가
    }
}
