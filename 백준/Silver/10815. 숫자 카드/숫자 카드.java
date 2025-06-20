import java.io.*;
import java.util.*;


public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine()); // 카드의 개수
        int[] cards = new int[N];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
 
        Arrays.sort(cards); // 이분탐색할 배열은 정렬되어 있어야 함.
        int M = Integer.parseInt(br.readLine()); // 구별할 수의 개수
 
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(cards, N, temp) + " ");
        }
 
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static int binarySearch(int[] cards, int N, int search) {
        int first = 0;
        int last = N - 1;
        int mid = 0;
 
        while (first <= last) {
            mid = (first + last) / 2; // 중간 인덱스
 
            if (cards[mid] == search) { // 중간값과 찾으려는 수가 같은 경우
                return 1;
            }
 
            if (cards[mid] < search) { // 중간값이 찾으려는 수보다 작으면, 그 이하로는 볼 필요 없음.
                first = mid + 1;
            } else { // 중간값이 찾으려는 수보다 크면, 그 이상으로는 볼 필요 없음.
                last = mid - 1;
            }
        }
 
        return 0;
    }
 
}
