import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        answer = new char[n][n];

        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void star(int x, int y, int N, boolean blank) {
        // 공백칸일 경우
        if(blank) {
            for(int i = x; i < x + N; i++) {
                for(int j = y; j < y + N; j++) {
                    answer[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 블록일 때
        if(N == 1) {
            answer[x][y] = '*';
            return;
        }

        int size = N/3;
        int count = 0;
        for(int i = x; i < x + N; i += size) {
            for(int j = y; j < y + N; j += size) {
                count++;
                if(count == 5) {	// 공백 칸일 경우
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
