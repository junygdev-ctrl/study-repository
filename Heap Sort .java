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
            int[] sortedArray = HeapSortUtil.heapSort(array);

            for (int element : sortedArray) {
                System.out.println(element);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}

class HeapSortUtil {
    public static int[] heapSort(int[] array) {
        int[] arrayC = array.clone();
        int lastIndex = arrayC.length - 1;
        buildHeap(arrayC, lastIndex);

        while (lastIndex > 0) {
            swap(arrayC, 0, lastIndex--);
            percolateDown(arrayC, 0, lastIndex);
        }
        return arrayC;
    }

    static void buildHeap(int[] array, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            percolateDown(array, i, lastIndex);
        }
    }

    static void percolateDown(int[] array, int index, int lastIndex) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild <= lastIndex) {
            if (rightChild <= lastIndex) {
                if (array[leftChild] < array[rightChild]) {
                    leftChild = rightChild;
                }
            }
            if (array[leftChild] > array[index]) {
                swap(array, index, leftChild);
                percolateDown(array, leftChild, lastIndex);
            }
        }
    }

    static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
