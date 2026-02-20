import java.util.*;

class Solution {
    public String solution(String s) {
        // 1. 공백을 기준으로 문자열 분리
        String[] parts = s.split(" ");
        int[] nums = new int[parts.length];
        
        // 2. 문자열 배열을 정수 배열로 변환
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        
        // 3. 정렬을 통해 최솟값과 최댓값 찾기
        Arrays.sort(nums);
        
        // 4. 결과 형식에 맞게 문자열 생성 ("최솟값 최댓값")
        return nums[0] + " " + nums[nums.length - 1];
    }
}