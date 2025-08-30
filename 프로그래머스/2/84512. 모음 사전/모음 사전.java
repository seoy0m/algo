class Solution {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static int answer;   // 결과
    static int count;    // 몇 번째 단어인지 세는 카운터
    
    public int solution(String word) {
        answer = 0;
        count = 0;
        dfs("", word);   // 빈 문자열부터 시작
        return answer;
    }
    
    static void dfs(String cur, String target) {
        // 길이가 5가 되면 더 이상 진행하지 않음
        if (cur.length() > 5) return;
        
        // 단어를 하나 만들었으니 카운트 증가
        if (cur.length() > 0) { 
            count++;
            if (cur.equals(target)) {
                answer = count;
                return;
            }
        }
        
        // 아직 목표 단어를 못 찾았으면 더 뻗어나가기
        for (int i = 0; i < 5; i++) {
            if (answer != 0) return; // 이미 찾으면 바로 종료
            dfs(cur + vowels[i], target);
        }
    }
}