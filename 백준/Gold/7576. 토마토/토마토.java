import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static boolean[][] visites;
	static Queue<int[]> q = new LinkedList<>();

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		int[] start = new int[2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					start[0] = i;
					start[1] = j;
					q.add(new int[] {start[0], start[1], 1});
				}
			}
		}
		
		bfs();
		
		boolean chk=true;
		int max=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				//최대 걸린 일수 체크
				if(arr[i][j]>max)
					max= arr[i][j];
				if(arr[i][j]==0)
					chk=false;
					
			}
		}
		int ans=-1;
		if(chk)
			ans= max-1;
		
		
		System.out.println(ans);
		

	}// main

	private static void bfs() {		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			
			for(int k =0; k<4; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				
				if(ni>=n || ni<0|| nj>=m||nj<0||arr[ni][nj]!=0 )
					continue;
				
				q.add(new int[] {ni,nj,curr[2]+1});
				arr[ni][nj]=curr[2]+1;
				
			}			
			
		}
		
	}
	
	

}