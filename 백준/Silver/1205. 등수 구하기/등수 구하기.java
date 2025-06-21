import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int new_score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, Collections.reverseOrder());

        if (n == p && n > 0 && new_score <= arr[arr.length - 1]) {
            System.out.print(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < arr.length; i++) {
                if (new_score < arr[i]) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.print(rank);
        }
    }
}
