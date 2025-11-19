import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());
            int[] array = new int[num];
            MergeSort ms = new MergeSort(num);

            for (int i = 0; i < num; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            ms.mergeSort(array, 0, array.length - 1);

            for (int i = 0; i < num; i++) {
                System.out.println(array[i]);
            }

        } catch (IOException | IllegalArgumentException e) {
            System.err.print(e.getMessage());
        }
    }
}

class MergeSort {
    private int[] temp;

    public MergeSort(int arraySize){
        this.temp = new int[arraySize];
    }

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int half = (left + right) / 2;
            mergeSort(array, left, half);
            mergeSort(array, half + 1, right);
            merge(array, left, half, right);
        }
    }

    private void merge(int[] array, int left, int half, int right) {
        int p = left;
        int q = half + 1;
        int i = left;

        while (p <= half && q <= right) {
            if (array[p] < array[q]) {
                temp[i++] = array[p++];
            } else {
                temp[i++] = array[q++];
            }
        }
        while (p <= half) {
            temp[i++] = array[p++];
        }
        while (q <= right) {
            temp[i++] = array[q++];
        }
        for(int j = left; j <= right; j++){
            array[j] = temp[j];
        }
    }
}

