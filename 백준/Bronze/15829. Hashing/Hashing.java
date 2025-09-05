import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int r = 31;
        int m = 1234567891;
        String s ="abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <26 ; i++) {
            map.put(s.charAt(i), i+1);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (map.get(str.charAt(i))%m)*((int) Math.pow(r,i) %m);
        }

        System.out.println(sum);


    };


}
