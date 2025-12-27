import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R, count =1;
    static ArrayList<Integer>[] graph;
    static int[] isVisited;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());

         isVisited = new int[N+1];
         graph = new ArrayList[N+1];
         visited = new boolean[N+1];

         for (int i = 1; i <= N; i++) {
             graph[i] = new ArrayList<>();
         }

         for (int i = 1; i <= M; i++) {
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             graph[a].add(b);
             graph[b].add(a);
         }

         for (int i = 1; i <= N; i++) {
             graph[i].sort(Collections.reverseOrder());
         }

         BFS(R);
         //DFS(R);

         StringBuilder sb = new StringBuilder();
         for (int i = 1; i <= N; i++) {
             sb.append(isVisited[i]).append("\n");
         }
         System.out.println(sb);
    }
    

    static void DFS(int start) {
        isVisited[start] = count++;

        for (int next : graph[start]) {
            if (isVisited[next] == 0) {
                DFS(next);
            }
        }
    }
    
    static void  BFS(int start) {
        queue.add(start);
        visited[start] = true;
        isVisited[start] = count++;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    isVisited[next] = count++;
                  
                }
            }
        }
    }
}

