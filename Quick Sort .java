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
            int[] arrayC = array.clone();
            QuickSort.sort(arrayC, 0, arrayC.length - 1);

            for (int element : arrayC) {
                System.out.println(element);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.print(e.getMessage());
        }
    }
}

class QuickSort {
    private static final Random random = new Random();

    public static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int cutLine = partition(array, startIndex, endIndex);
            sort(array, startIndex, cutLine - 1);
            sort(array, cutLine + 1, endIndex);
        }
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivotIndex = choosePivotIndex(startIndex, endIndex);
        swap(array, pivotIndex, endIndex);
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] < array[endIndex]) {
                swap(array, ++i, j);
            }
        }
        swap(array, i + 1, endIndex);
        return i + 1;
    }

    private static int choosePivotIndex(int indexA, int indexB) {
        return random.nextInt(indexB - indexA + 1) + indexA;
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}

