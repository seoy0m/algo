import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        //제곱수만 열려있음
        int ans = (int) Math.floor(Math.sqrt(n));

        System.out.println(ans);

    }
}
