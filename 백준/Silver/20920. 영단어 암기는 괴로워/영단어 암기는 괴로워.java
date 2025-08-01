import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() >= m) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        // 정렬 조건
        list.sort((o1, o2) -> {
            int cnt1 = map.get(o1);
            int cnt2 = map.get(o2);

            // 1) 자주 나오는 단어 먼저
            if (cnt1 != cnt2) return cnt2 - cnt1; //내림차순
            // 2) 길이가 긴 단어 먼저
            if (o1.length() != o2.length()) return o2.length() - o1.length(); //내림차순
            // 3) 사전순
            return o1.compareTo(o2);
        });

        
        for (String word : list) {
            sb.append(word).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
