import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] T = new int[N + 1]; // 1-based
        int[] P = new int[N + 1]; // 1-based
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = "i일까지" 얻을 수 있는 최대 수익 (접두 최대)
        int[] dp = new int[N + 2]; // dp[N+1]까지 접근 가능하도록 +2

        for (int i = 1; i <= N; i++) {
            // 스킵(이월): i-1일까지의 최대를 i일까지 반영
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // 수락: i일에 시작해서 i+T[i]-1일에 끝남
            // 조건: i + T[i] <= N + 1  (마지막 근무일이 N일이면 OK)
            int finish = i + T[i];
            if (finish <= N + 1) {
                dp[finish] = Math.max(dp[finish], dp[i] + P[i]);
            }
        }

        // 마지막 날까지 이월
        dp[N + 1] = Math.max(dp[N + 1], dp[N]);

        // 정답: 퇴사 시점까지의 최대 (dp[N] 또는 dp[N+1] 동일하게 안전 처리)
        System.out.println(Math.max(dp[N], dp[N + 1]));
    }
}
