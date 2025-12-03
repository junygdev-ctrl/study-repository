import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        CoordinateCompressor cc = new CoordinateCompressor();
        FastReader fr = new FastReader();
        try {
            int num = fr.nextInt();

            int[] array = new int[num];

            for (int i = 0; i < num; i++) {
                array[i] = fr.nextInt();
            }

            int[] result = cc.compress(array);

            for (int element : result) {
                sb.append(element).append(' ');
            }

            System.out.print(sb);

        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }

    static class FastReader {
        BufferedReader br;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() throws IOException {
            int ret = 0;
            int k = br.read();
            boolean isMinus = false;

            while (k <= ' ') {
                k = br.read();
            }

            if (k == '-') {
                isMinus = true;
                k = br.read();
            }

            do {
                ret = ret * 10 + k - '0';
            } while ((k = br.read()) >= '0' && k <= '9');

            if (isMinus) {
                ret *= -1;
            }

            return ret;
        }
    }
}

class CoordinateCompressor {
    public int[] compress(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int element : array) set.add(element);

        Integer[] temp = set.toArray(new Integer[0]);
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) map.put(temp[i], i);

        int[] result = array.clone();
        for (int i = 0; i < array.length; i++) {
            result[i] = map.get(array[i]);
        }
        return result;
    }
}
