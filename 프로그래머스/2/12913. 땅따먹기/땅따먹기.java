import java.util.*;

class Solution {
    int solution(int[][] land) {
        // prev[c] = 직전 행에서 c열을 골랐을 때의 최대 합
        int[] prev = new int[4];
        // 첫 행 초기화
        for (int c = 0; c < 4; c++) prev[c] = land[0][c];

        for (int i = 1; i < land.length; i++) {
            int[] cur = new int[4];
            for (int c = 0; c < 4; c++) {
                // 윗행에서 같은 열을 제외한 최대값
                int bestAbove = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == c) continue;
                    if (prev[k] > bestAbove) bestAbove = prev[k];
                }
                cur[c] = land[i][c] + bestAbove;
            }
            prev = cur; // 롤링
        }

        // 마지막 행에서의 최대값이 전체 최대
        int answer = 0;
        for (int c = 0; c < 4; c++) answer = Math.max(answer, prev[c]);
        return answer;
    }
}
