import java.util.*;
import java.io.*;

public class Main {
    private static int bound;
    private static int size;
    private static boolean[] isUsed;
    private static int[] sequence;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        bound = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        isUsed = new boolean[bound + 1];
        sequence = new int[size];

        generateSequence(0);

        System.out.print(sb);
    }

    private static void generateSequence(int depth) {
        if (depth == size) {
            appendSequenceToBuilder();
            return;
        }

        for (int i = 1; i <= bound; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sequence[depth] = i;

                generateSequence(depth + 1);

                isUsed[i] = false;
            }
        }
    }

    private static void appendSequenceToBuilder() {
        for (int element : sequence) {
            sb.append(element).append(' ');
        }

        sb.append('\n');
    }

}


