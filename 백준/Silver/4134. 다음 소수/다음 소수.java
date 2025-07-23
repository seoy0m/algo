import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(br.readLine());
            while (true){
                long cnt = 0;
                for (int j=2; j<=Math.sqrt(a); j++){
                    if(a%j==0){
                        cnt++;
                        break;
                    }
                }

                if (cnt==0){
                    if (a==0|| a==1){
                        a=2;
                    }
                    System.out.println(a);
                    break;
                }
                a++;
            }
        }



    }
}
