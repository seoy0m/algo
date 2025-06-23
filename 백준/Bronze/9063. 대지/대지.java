import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int xmin =10000;
        int ymin =10000;
        int xmax =-10000;
        int ymax =-10000;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            xmin = Math.min(xmin,a);
            xmax = Math.max(xmax,a);

            ymin = Math.min(ymin,b);
            ymax = Math.max(ymax,b);
        }

        if(n==1){
            System.out.println(0);
        } else System.out.println((xmax-xmin)*(ymax-ymin));

    }
}