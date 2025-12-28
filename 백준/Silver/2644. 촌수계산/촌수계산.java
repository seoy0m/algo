import java.io.*;
import java.util.*;

public class Main {

    static int n,x,y,m,ans;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        visited = new boolean[n+1];
        
        st  = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        m = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }


        ans = -1;
        dfs(x,y,0);

        System.out.println(ans);

    }

    static void dfs(int start, int end, int cnt) {
        if (start == end) {
            ans=cnt;
            return;
        }

        visited[start]=true;
        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next, end, cnt+1);
            }
        }
    }
}

