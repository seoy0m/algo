import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] miro;
	static boolean[][] visited;
	static int n,m;
	static int ans;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 
		 miro = new int[n][m];
		 visited = new boolean[n][m];
		 
		//미로에서 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
		 for(int i=0; i<n; i++) {
			 String str = br.readLine();
			 for(int j =0; j<m;j++) {
				 miro[i][j] = str.charAt(j)-'0';
			 }
		 }//미로 입력 받기
		 
		 bfs(new int[] {0,0,0});
		 
		 System.out.println(ans);

	}//main

	private static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		
		start[2]=1;
		q.add(start);
		visited[start[0]][start[1]]= true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			
			for(int k =0; k<4; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				
				if(ni<0|| ni>= n|| nj <0|| nj>=m||visited[ni][nj]||miro[ni][nj]==0)
					continue;
				
				q.add(new int[] {ni,nj,curr[2]+1});
				visited[ni][nj]= true;
				
				if(ni==n-1 && nj== m-1)
					ans= curr[2]+1;
					
			}
		}
		
	}

	
}