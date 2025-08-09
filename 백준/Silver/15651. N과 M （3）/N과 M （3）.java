import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] visited;
	static int[] result;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		visited = new boolean[n];
		result = new int[m];
		
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		

		perm(arr, 0);
		bw.flush();
		bw.close();
			

	}
	
	//중복 수열
	static void perm(int[] arr, int idx) throws IOException {
		// 기저
		if (idx == m) {
			StringBuilder sb = new StringBuilder();
			for(int i =0; i<result.length;i++) {
			sb.append(result[i]).append(" ");
		}
			bw.write(sb.toString().trim());
			bw.newLine();
			return;
		}
		

		// 재귀
		for(int i=0; i<n;i++) {
			if(visited[i])
				continue;
			result[idx]=arr[i];
			
			perm(arr, idx+1);
			
		}
		
	}

}