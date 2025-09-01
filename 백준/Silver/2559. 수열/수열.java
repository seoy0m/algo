import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 초기 K개 합
        int windowSum = 0;
        for (int i = 0; i < K; i++) windowSum += arr[i];

        int maxSum = windowSum;

        // 슬라이딩 윈도우로 최댓값 갱신
        for (int i = K; i < N; i++) {
            windowSum += arr[i] - arr[i - K]; // 새로 들어온 값 더하고, 빠지는 값 빼기
            if (windowSum > maxSum) maxSum = windowSum;
        }

        System.out.println(maxSum);
    }
}
