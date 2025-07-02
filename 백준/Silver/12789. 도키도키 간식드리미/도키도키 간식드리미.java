import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Queue<Integer> q= new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        int now =1;

        while (!q.isEmpty()) {
            int front = q.poll();
            if (front == now) {
                now++;
            } else {
                // 스택 위에 지금 순서가 있으면 pop
                while (!stack.isEmpty() && stack.peek() == now) {
                    stack.pop();
                    now++;
                }
                stack.push(front);
            }
        }

        // 줄이 비고 나서 스택 처리
        while (!stack.isEmpty()) {
            if (stack.peek() == now) {
                stack.pop();
                now++;
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }

    }
}