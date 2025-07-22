import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 거리차 배열
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = arr[i + 1] - arr[i];
        }

        // 거리차의 최대공약수 구하기
        int g = dist[0];
        for (int i = 1; i < dist.length; i++) {
            g = gcd(g, dist[i]);
        }

        // 심어야 하는 나무 수 구하기
        int ans = 0;
        for (int d : dist) {
            ans += d / g - 1;
        }

        System.out.println(ans);
    }
}