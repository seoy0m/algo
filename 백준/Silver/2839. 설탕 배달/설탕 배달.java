import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        
        int ans=-1;

        out: for(int i = n/5 ; i >=0; i--){
            int ck=n;
            ck-= i*5;

             for(int j =0 ; j <= n/3; j++){
                if(ck==3*j){
                    ans = i+j;
                    System.out.println(ans);
                    break out;
                }
            }

        }
        
        if(ans==-1){
            System.out.println(ans);
        }


    }
}