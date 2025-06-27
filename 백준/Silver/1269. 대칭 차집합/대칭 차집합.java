import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        for(int i =0; i<a;i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<b;i++){
            int x = Integer.parseInt(st.nextToken());
            if(A.contains(x)){
                A.remove(x);
            } else {
                B.add(x);
            }

        }

        int ans = A.size()+B.size();

        System.out.println(ans);
    }
}