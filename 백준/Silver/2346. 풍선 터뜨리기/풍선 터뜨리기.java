import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        Deque<int[]> dq = new ArrayDeque<>();
        
        for (int i = 1; i < n; i++) {
            dq.add(new int[]{i+1, arr[i]}); //풍선 번호, 풍선 내용
        }
        
        sb.append(1).append(" ");
        int now = arr[0];
        
        while (!dq.isEmpty()) {
            if (now>0){
                for (int i = 1; i < now; i++) {
                    dq.add(dq.poll());
                }
                
                int[] next = dq.poll();
                now = next[1];
                sb.append(next[0]).append(" ");
            }
            else {
                for (int i = 1; i < -now; i++) {
                    dq.addFirst(dq.pollLast());
                }
                
                int[] next = dq.pollLast();
                now = next[1];
                sb.append(next[0]).append(" ");
            }
        }
        

        System.out.println(sb.toString());

    }
}