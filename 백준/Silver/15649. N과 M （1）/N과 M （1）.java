import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] visited;
	static int[] result;

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

		perm(arr, 0);

	}

	static void perm(int[] arr, int idx) {
		// 기저
		if (idx == m) {
			for(int i =0; i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n;i++) {
			if(visited[i])
				continue;
			result[idx]=arr[i];
			visited[i]=true;
			perm(arr, idx+1);
			visited[i]=false;
		}
	}
}