import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        final long r = 31L;
        final long m = 1234567891L;

        long hash = 0L;
        long pow = 1L; // r^0

        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - 'a' + 1;   // 'a' -> 1, ..., 'z' -> 26
            hash = (hash + (val * pow) % m) % m;
            pow = (pow * r) % m;               // 다음 자릿수의 r^i
        }

        System.out.println(hash);
    }
}
