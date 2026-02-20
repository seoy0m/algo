import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 모든 번호를 해시맵에 넣기
        for (String number : phone_book) {
            map.put(number, 1);
        }

        // 2. 각 번호의 접두어가 맵에 있는지 확인
        for (String number : phone_book) {
            for (int j = 1; j < number.length(); j++) {
                // 앞에서부터 한 글자씩 늘려가며 확인
                if (map.containsKey(number.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}