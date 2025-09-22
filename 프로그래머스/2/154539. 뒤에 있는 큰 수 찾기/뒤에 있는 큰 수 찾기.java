import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 기본값 -1

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 저장 (값이 내림차순이 되도록 유지)

        for (int i = 0; i < n; i++) {
            // 현재 값이 더 크면, 스택 위 인덱스들의 뒤 큰 수를 현재 값으로 채움
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i); // 아직 못 찾은 인덱스 보관
        }
        return answer;
    }
}
