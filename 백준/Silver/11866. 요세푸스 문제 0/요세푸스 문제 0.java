import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q1 = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q1.add(i);
        }

        while (q1.size() > 1) {

            for (int i =0; i<K-1; i++) {
                int a = q1.poll();
                q1.add(a);
            }

            sb.append(q1.poll()).append(", ");
        }

        sb.append(q1.poll()).append(">");

        System.out.println(sb.toString());

    }
}