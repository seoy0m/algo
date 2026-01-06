import java.util.*;

class Solution {
    // 부모 노드를 저장할 배열
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        // 1. 초기화: 각 섬의 부모를 자기 자신으로 설정
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 2. 비용(costs[2])을 기준으로 오름차순 정렬
        // 람다식을 사용하여 가독성 있게 정렬합니다.
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // 3. 간선을 하나씩 확인하며 MST 구축
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            // 두 섬의 부모가 다르다면(연결되어 있지 않다면)
            if (find(from) != find(to)) {
                union(from, to); // 두 섬을 합치고
                answer += cost;  // 비용 추가
            }
        }

        return answer;
    }

    // Find: 최상위 부모(root)를 찾는 메서드 (경로 압축 포함)
    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 부모를 루트로 갱신하여 경로 단축
    }

    // Union: 두 집합을 하나로 합치는 메서드
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}