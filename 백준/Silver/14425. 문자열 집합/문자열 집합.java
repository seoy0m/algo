import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            list.add(s);
        }
        
        for (int i=0; i<m; i++) {
            String s = br.readLine();
            if(list.contains(s)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}