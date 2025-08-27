import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(abc(a, b, c));
    }

    // 분할 정복: a^b % c (재귀 깊이 O(log b))
    static long abc(long a, long b, long c) {
        if (b == 0) return 1 % c;      // c==1 대비
        if (b == 1) return a % c;

        long half = abc(a, b / 2, c);          // a^(b/2) % c
        long res = (half * half) % c;          // (a^(b/2))^2 % c

        if ((b & 1) == 1) {                    // b가 홀수면 한 번 더 곱함
            res = (res * (a % c)) % c;
        }
        return res;
    }
}
