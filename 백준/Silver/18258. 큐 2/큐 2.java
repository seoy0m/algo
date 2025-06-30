import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")){
                q.add(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                } else sb.append(q.poll()).append("\n");
            } else if (str.equals("size")){
                int a = q.size();
                sb.append(a).append("\n");
            } else if (str.equals("empty")){
                if(q.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            } else if (str.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                } else sb.append(q.peek()).append("\n");
            } else if (str.equals("back")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                } else sb.append(q.peekLast()).append("\n");
            }
        }



        System.out.println(sb);
    }
}