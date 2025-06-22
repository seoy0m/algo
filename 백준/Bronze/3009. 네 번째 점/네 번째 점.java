import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a,map.getOrDefault(a,0) + 1);
            map2.put(b,map2.getOrDefault(b,0) + 1);
        }

        int x=0;
        int y=0;

        for(Integer i : map.keySet()) {
            if(map.get(i)==1){
                x=i;
            }
        }

        for(Integer i : map2.keySet()) {
            if(map2.get(i)==1){
                y=i;
            }
        }
        System.out.println(x+" "+y);
    }
}