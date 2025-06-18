
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            max = Math.max(a, Math.max(b, c));
            if (max*2 -(a+b+c) >= 0 || a==0 || b==0 || c==0) System.out.println("Invalid");
            else {
                if (a == b && b == c && c == a) System.out.println("Equilateral ");
                else if (a == b || b == c || c == a) System.out.println("Isosceles");
                else System.out.println("Scalene");
            }

        }

    }
}