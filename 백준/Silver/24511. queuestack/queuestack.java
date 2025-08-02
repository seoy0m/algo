import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] type = new int[n]; // 0=queue, 1=stack
        int[] value = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) type[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (type[i] == 0) deque.add(v); // queue만 유지
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            deque.addFirst(x);      // 새 값은 덱 앞에 추가
            sb.append(deque.removeLast()).append(" "); // 맨 뒤 값 출력
        }

        System.out.println(sb.toString());
    }
}
