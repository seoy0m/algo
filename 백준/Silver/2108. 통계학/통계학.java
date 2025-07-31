import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        Map<Integer, Integer> freq = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr);

        // 1. 산술평균 (반올림)
        int mean = (int)Math.round((double)sum / n);

        // 2. 중앙값
        int median = arr[n/2];

        // 3. 최빈값 (여러 개면 두 번째로 작은 값)
        int maxFreq = Collections.max(freq.values());
        List<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == maxFreq) {
                modeList.add(e.getKey());
            }
        }
        Collections.sort(modeList);
        int mode = modeList.size() >= 2 ? modeList.get(1) : modeList.get(0);

        // 4. 범위
        int range = arr[n-1] - arr[0];

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
