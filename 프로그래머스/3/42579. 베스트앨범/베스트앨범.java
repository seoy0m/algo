import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> num = new HashMap<>(); // 장르별 총 재생수
        Map<String, Map<Integer, Integer>> music = new HashMap<>(); // 장르 -> (곡 인덱스 -> 재생수)

        for (int i = 0; i < plays.length; i++) {
            String g = genres[i];
            int p = plays[i];

            if (!num.containsKey(g)) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, p);
                music.put(g, map);
                num.put(g, p);
            } else {
                music.get(g).put(i, p);
                num.put(g, num.get(g) + p);
            }
        }

        // 장르를 총 재생수 내림차순으로 정렬
        List<String> keySet = new ArrayList<>(num.keySet());
        keySet.sort((s1, s2) -> Integer.compare(num.get(s2), num.get(s1)));

        for (String key : keySet) {
            Map<Integer, Integer> map = music.get(key);
            List<Integer> genreKey = new ArrayList<>(map.keySet());

            // 장르 내에서: 재생수 내림차순, 동률이면 인덱스 오름차순
            genreKey.sort((a, b) -> {
                int pa = map.get(a);
                int pb = map.get(b);
                if (pa != pb) return Integer.compare(pb, pa); // plays desc
                return Integer.compare(a, b); // idx asc on tie
            });

            answer.add(genreKey.get(0));
            if (genreKey.size() > 1) answer.add(genreKey.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
