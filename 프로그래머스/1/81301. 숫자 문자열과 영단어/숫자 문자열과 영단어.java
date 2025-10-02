import java.util.*;
/*
        1.해당하는 문자가 있으면 그 시작 인덱스랑 그 문자의 수 넣음
        2.해당하는 숫자가 있으면 그 시작 인덱스랑 그 숫자 넣음
        3.위를 반복
        4.만약 해당 인덱스가 이미 넣어져 있으면 스탑모드로 바꾸는 걸로
        */
class Solution {
    public int solution(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replace(nums[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);

        
        
    }
}