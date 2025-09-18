class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s.length());
        n %= 26; // n이 26보다 클 수 있으니 미리 정규화

        for (char c : s.toCharArray()) {
            if (c == ' ') { // 공백은 아무리 밀어도 공백입니다.
                sb.append(' ');
                continue;
            }
            if (c >= 'A' && c <= 'Z') { // 대문자
                int shifted = (c - 'A' + n) % 26;
                sb.append((char) ('A' + shifted));
            } else if (c >= 'a' && c <= 'z') { // 소문자
                int shifted = (c - 'a' + n) % 26;
                sb.append((char) ('a' + shifted));
            } else {
                // 알파벳/공백 외 문자는 문제 조건상 없지만, 혹시 모르면 그대로 둠
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
