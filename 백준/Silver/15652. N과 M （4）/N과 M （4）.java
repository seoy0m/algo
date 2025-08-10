import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		int[] pick = new int[m];

		combination(arr, pick, 0, 0);

	}

	static void combination(int[] arr, int[] sel, int idx, int sidx) {
		// 기저
		if (sidx == m) {
//			System.out.println(Arrays.toString(sel));
			for(int i =0; i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if (idx == n)
			return;

		// 재귀
		sel[sidx] = arr[idx];
		combination(arr, sel, idx, sidx + 1);
		combination(arr, sel, idx + 1, sidx);
	}

}