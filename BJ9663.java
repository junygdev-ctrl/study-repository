import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sizeN = Integer.parseInt(br.readLine());

        Queen queen = new Queen(sizeN);

        queen.generate(0);

        System.out.println(queen.getCount());
    }
}

class Queen {
    private final int sizeN;
    private final int[] board;
    private int count = 0;

    Queen(int sizeN) {
        this.sizeN = sizeN;
        this.board = new int[sizeN];
    }

    public void generate(int depth) {
        if (depth == sizeN) {
            count++;
            return;
        }

        for (int i = 0; i < sizeN; i++) {
            if (!isValid(depth, i)) continue;
            board[depth] = i;

            generate(depth + 1);
        }
    }

    private boolean isValid(int index, int value) {
        for (int i = 0; i < index; i++) {
            if (board[i] == value) return false;
            if (Math.abs(index - i) == Math.abs(value - board[i])) return false;
        }

        return true;
    }

    public int getCount() {
        return count;
    }
}
