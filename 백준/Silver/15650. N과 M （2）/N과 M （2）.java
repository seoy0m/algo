import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr= new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		sel =new int[m];

		com(0, 0);

	}

	static void com(int idx, int sidx) {
		if (sidx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx == n)
			return;
        
		sel[sidx] = arr[idx];
		com(idx + 1, sidx + 1);
		com(idx + 1, sidx);
	}

}