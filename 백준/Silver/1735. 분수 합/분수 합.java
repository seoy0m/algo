import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int A = a1*b2 + a2*b1;
        int B = b1*b2;

        int mod = gcd(A, B);
        A /= mod;
        B /= mod;

        sb.append(A).append(" ").append(B);
        System.out.println(sb.toString());

    }

    // 유클리드 호제법
    public static int gcd(int a, int b) {
        // a가 b보다 큰 경우에 대해서 유클리드 호제법 수행.
        if (a <= b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }

    
}