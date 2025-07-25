import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int ans=0;
            for (int i = n+1; i <= n*2; i++) {
                boolean chk = true;
                for (int j =2; j<=Math.sqrt(2*n); j++){
                    if (i%j==0){
                        chk = false;
                        break;
                    }
                }

                if (chk) ans++;
            }
            System.out.println(ans);
        }

    }
}
