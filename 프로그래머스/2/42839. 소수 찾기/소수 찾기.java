import java.util.*;

class Solution {
    static boolean[] notPrime;      
    static boolean[] used;          // DFS에서 해당 인덱스의 숫자 사용 여부
    static Set<Integer> made;       // 중복 숫자 방지
    static int answer;

    public int solution(String numbers) {
        int n = numbers.length();

        // 상한: 10^n (길이 n으로 만들 수 있는 최대 수는 10^n - 1)
        int limit = 1;
        for (int i = 0; i < n; i++) limit *= 10;

        // 소수 테이블 구성
        notPrime = sieve(limit);

        // DFS 준비
        char[] digits = numbers.toCharArray();
        used = new boolean[n];
        made = new HashSet<>();
        answer = 0;

        // DFS로 길이 1~n의 모든 수 만들기
        dfs(digits, 0, 0);

        return answer;
    }

    // cur: 현재까지 만든 수, depth: 지금까지 붙인 자릿수 개수
    static void dfs(char[] digits, int depth, int cur) {
        // 길이가 1 이상이면 지금까지 만든 수를 체크
        if (depth > 0) {
            if (!made.contains(cur)) {
                made.add(cur);
                if (!notPrime[cur]) answer++;
            }
        }
        // 최대 길이에 도달했으면 종료
        if (depth == digits.length) return;

        // 아직 쓰지 않은 숫자를 붙여서 다음 단계로
        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            used[i] = true;

            int next = cur * 10 + (digits[i] - '0');  // '0'을 빼야 숫자 변환
            dfs(digits, depth + 1, next);

            used[i] = false;
        }
    }

    // 에라토스테네스의 체
    static boolean[] sieve(int n) {
        boolean[] np = new boolean[n];
        if (n > 0) np[0] = true;
        if (n > 1) np[1] = true;

        for (int i = 2; i * i < n; i++) {
            if (!np[i]) {
                for (int j = i * i; j < n; j += i) np[j] = true;
            }
        }
        return np;
    }
}