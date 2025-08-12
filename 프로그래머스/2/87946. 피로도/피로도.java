import java.util.*;

class Solution {

    static boolean[] visited;
    static int max, n;

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        max = 0;

        dfs(k, dungeons, 0);
        return max;
    }

    static void dfs(int k, int[][] arr, int cnt) {
        // 지금까지 방문한 개수로 갱신
        if (cnt > max) max = cnt;

        // 다음에 갈 수 있는 모든 던전 시도
        for (int i = 0; i < n; i++) {
            if (!visited[i] && k >= arr[i][0]) {       // 요구치 충족 + 미방문
                visited[i] = true;
                dfs(k - arr[i][1], arr, cnt + 1);      // 소모 피로도 차감
                visited[i] = false;
            }
        }
        // 더 갈 수 있는 던전이 없으면 자연스럽게 리턴
    }
}
