import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sb.append(arr[i]/25).append(" ");
            arr[i]%=25;
            sb.append(arr[i]/10).append(" ");
            arr[i]%=10;
            sb.append(arr[i]/5).append(" ");
            arr[i]%=5;
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb.toString());

    }
}