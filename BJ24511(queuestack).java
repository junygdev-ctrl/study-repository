import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        try {
            br.readLine();

            StringTokenizer typeTokens = new StringTokenizer(br.readLine());

            StringTokenizer elementTokens = new StringTokenizer(br.readLine());

            while (typeTokens.hasMoreTokens()) {
                int element = Integer.parseInt(elementTokens.nextToken());

                if (typeTokens.nextToken().equals("0")) {
                    deque.offerFirst(element);
                }
            }

            int countM = Integer.parseInt(br.readLine());

            StringTokenizer inputTokens = new StringTokenizer(br.readLine());

            while (inputTokens.hasMoreTokens()) {
                int value = Integer.parseInt(inputTokens.nextToken());

                deque.offer(value);
                sb.append(deque.poll()).append(' ');
            }

            sb.delete(sb.length() - 1, sb.length());

        } catch (IOException e) {
            System.err.print(e.getMessage());
        }

        System.out.println(sb);
    }
}
