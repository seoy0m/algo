import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            g[v].add(u);
        }

        // 인접 리스트 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            g[i].sort(Collections.reverseOrder());
        }

        int[] order = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] nextIdx = new int[N + 1]; // 각 정점에서 다음으로 탐색할 인접 정점 인덱스
        int cnt = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(R);

        while (!stack.isEmpty()) {
            int v = stack.peek();

            if (!visited[v]) {
                visited[v] = true;
                order[v] = ++cnt;
            }

            // 다음 인접 정점 탐색
            if (nextIdx[v] < g[v].size()) {
                int to = g[v].get(nextIdx[v]++);
                if (!visited[to]) {
                    stack.push(to);
                }
            } else {
                // 더 갈 곳 없으면 backtrack
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.print(sb);
    }
}
