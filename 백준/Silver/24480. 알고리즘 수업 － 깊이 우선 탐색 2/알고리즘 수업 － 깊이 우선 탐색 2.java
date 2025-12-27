import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R, count = 1; // 정점 수, 간선 수, 시작 정점, 방문 순서 카운트
    static ArrayList<Integer>[] list; // 인접 리스트
    static int[] isVisited; // 방문 순서 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        N = sToInt(st.nextToken()); // 정점 개수
        M = sToInt(st.nextToken()); // 간선 개수
        R = sToInt(st.nextToken()); // 시작 정점

        isVisited = new int[N + 1]; // 방문 순서 저장 배열
        list = new ArrayList[N + 1];

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = sToInt(st.nextToken());
            int b = sToInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // 내림차순 정렬 (큰 숫자부터 탐색)
        for (int i = 1; i <= N; i++) {
            list[i].sort(Collections.reverseOrder());
        }

        // DFS 실행
        DFS(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(isVisited[i]).append("\n");
        }
        System.out.println(sb);
    }

    // 문자열 -> 정수 변환 함수
    static int sToInt(String s) {
        return Integer.parseInt(s);
    }

    // 깊이 우선 탐색 (DFS)
    static void DFS(int start) {
        isVisited[start] = count++; // 방문 순서 기록

        for (int next : list[start]) { // 연결된 정점 순회
            if (isVisited[next] == 0) { // 방문하지 않은 경우
                DFS(next);
            }
        }
    }
}