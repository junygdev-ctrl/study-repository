import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            int[] array = new int[num];

            for (int i = 0; i < num; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            int[] sortedArray = CountingSort.getSortedArray(array);

            for (int i : sortedArray) {
                System.out.println(i);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}

class CountingSort {
    public static int[] getSortedArray(int[] array) {
        int[] arrayC = array.clone();
        int[] countArray = new int[ArrayUtils.getMaxValue(array) + 1];

        for (int i : arrayC) {
            countArray[i]++;
        }
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                arrayC[index++] = i;
            }
        }
        return arrayC;
    }
}

class ArrayUtils {
    public static int getMaxValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : array) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
