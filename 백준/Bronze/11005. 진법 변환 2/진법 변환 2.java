import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int tmp =0;
        StringBuilder sb = new StringBuilder();

        while (n>0){
            tmp = n%b;
            if (tmp>=10){
                 char c = (char) (tmp+55);
                 sb.append(c);
            } else{
                sb.append(tmp);
            }

            n=n/b;

        }
        System.out.println(sb.reverse());

    }
}
