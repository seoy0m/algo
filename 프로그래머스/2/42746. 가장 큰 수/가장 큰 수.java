import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. 숫자를 문자열 배열로 변환
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 2. 커스텀 정렬: (b+a)와 (a+b)를 비교하여 내림차순 정렬
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 3. 예외 처리: 모든 숫자가 0인 경우 "000"이 아닌 "0"을 리턴해야 함
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 4. 문자열 합치기
        StringBuilder answer = new StringBuilder();
        for (String str : strNums) {
            answer.append(str);
        }

        return answer.toString();
    }
}