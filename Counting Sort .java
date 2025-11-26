import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (FastReader fr = new FastReader()) {
            int num = fr.nextInt();
            int[] array = new int[num];

            for (int i = 0; i < num; i++) {
                array[i] = fr.nextInt();
            }
            int[] sortedArray = CountingSort.getSortedArray(array);

            for (int i : sortedArray) {
                sb.append(i).append("\n");
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
        System.out.print(sb);
    }

    static class FastReader implements AutoCloseable {
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() throws IOException {
            int ret = 0;
            int i = br.read();
            while (i <= ' ') {
                i = br.read();
            }
            do {
                ret = ret * 10 + i - '0';
            } while ((i = br.read()) >= '0' && i <= '9');
            return ret;
        }

        @Override
        public void close() throws IOException {
            if (br != null) {
                br.close();
            }
        }
    }
}

class CountingSort {
    public static int[] getSortedArray(int[] array) {
        int[] countArray = new int[findMaxValue(array) + 1];
        int[] sortedArray = new int[array.length];

        for (int i : array) {
            countArray[i]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
        return sortedArray;
    }

    private static int findMaxValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;

        for (int i : array) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
