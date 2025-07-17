import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();
        int ans = 0;


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                map.clear();
            } else {
                if(map.get(s) == null) {
                    map.put(s,1);
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
