import java.io.*;

public class Main {
    static boolean[] isNotPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수 미리 구하기
        getPrime();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 2; i <= n / 2; i++) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void getPrime() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
