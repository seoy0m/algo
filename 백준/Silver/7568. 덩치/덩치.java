import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        for (int i = 0; i < n; i++) {
            int rank = 1; // 기본 등수는 1
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 자기 자신은 비교 X
                if (arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    rank++; // 자기보다 큰 덩치가 있으면 등수++
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
