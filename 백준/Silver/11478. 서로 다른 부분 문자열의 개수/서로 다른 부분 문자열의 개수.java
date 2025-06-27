import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String string = br.readLine();
       HashSet<String> set = new HashSet<>();
       int n = string.length();

       for (int i = 0; i < n; i++) {

           for (int j = i+1; j<=n; j++){

               set.add(string.substring(i, j));
           }
       }

        System.out.println(set.size());

    }
}