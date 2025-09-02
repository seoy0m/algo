import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // DP로 F(n) 계산 (1-indexed)
        int[] f = new int[Math.max(3, n + 1)];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int code1Cnt = f[n];   // 재귀에서 기본식이 실행된 횟수 == F(n)
        int code2Cnt = n - 2;  // DP 반복문의 실행 횟수

        System.out.println(code1Cnt + " " + code2Cnt);
    }
}
