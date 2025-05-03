

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] mine = new int[N];
        for(int i=0;i<N;i++){
            mine[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(mine);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] check = new int[M];
        for(int i=0;i<M;i++){
            check[i] = Integer.parseInt(st.nextToken());
            int ans= binary(check[i],mine,N);
            System.out.println(ans);
        }



    }

    public static int binary(int now, int[] mine, int n) {
        int left = 0;
        int right = n-1;
        int mid = 0;

        while(left<=right){
            mid = (left+right)/2;
            if(mine[mid]==now) return 1;
            if(mine[mid]<now){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
return 0;

    }
    }

