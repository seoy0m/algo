class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        // 1. 모든 문자를 일단 소문자로 변환 (전체 규칙 통일)
        String lowerS = s.toLowerCase();
        
        // 2. "이전 문자가 공백이었는가?"를 나타내는 플래그
        boolean isFirst = true;
        
        for (char c : lowerS.toCharArray()) { //문자열 배열로 변경
            // 3. 만약 이전이 공백(또는 첫 글자)이라면 대문자로 변환
            if (isFirst) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(c);
            }
            
            // 4. 현재 문자가 공백이면 다음 문자는 '첫 글자'가 됨
            isFirst = (c == ' ');
        }
        
        return answer.toString();
    }
}