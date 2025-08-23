import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int x1,x2,y1,y2;
    static int[] di = {-2,-1,1,2,2,1,-1,-2};
    static int[] dj = {1,2,2,1,-1,-2,-2,-1};
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int tc=1; tc<=t;tc++){
            l = Integer.parseInt(br.readLine());//체스판의 한 변의 길이

            arr = new int[l][l];
            visited =new boolean[l][l];

            //나이트가 현재 있는 칸
            st = new StringTokenizer(br.readLine());
            x1= Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            //나이트가 이동하려고 하는 칸
            st= new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());


            bfs(x1,y1);


            System.out.println(arr[x2][y2]);
        }//tc
    }//main

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x,y});
        visited[x][y]=true;

        
        while (!q.isEmpty()){

            int[] curr = q.poll();

                for (int dir = 0; dir<8;dir++){
                    int ni = curr[0]+di[dir];
                    int nj = curr[1]+dj[dir];

                    if (ni <l && ni>=0 && nj <l && nj>=0 && !visited[ni][nj]){//범위 안에 있고 방문한적이 없으면
                        q.add(new int[] {ni, nj});// 큐에 추가
                        arr[ni][nj] = arr[curr[0]][curr[1]]+1;// 전에 있던 칸 값에 1더함 , 이동 횟수 세기
                        visited[ni][nj]=true;//방문 췤

                    }
                }


        }

    }
}