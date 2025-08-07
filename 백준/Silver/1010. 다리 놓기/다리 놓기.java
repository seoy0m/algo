import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(BC(m,n));
        }


    }

    static int BC(int n , int m) {
        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        if (n==m||m==0){
            return dp[n][m]=1;
        }

        return dp[n][m] =  BC(n-1, m-1) + BC(n-1, m);
    }
}
