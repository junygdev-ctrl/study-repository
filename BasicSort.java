import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("배열의 각 요솟값을 입력하시오. : ");
            String[] tempArr = br.readLine().split(" ");
            int[] arr = new int[tempArr.length];

            for (int i = 0; i < tempArr.length; i++) {
                arr[i] = Integer.parseInt(tempArr[i]);
            }

            System.out.print("정렬 방식을 입력하시오. (선택 정렬: 1, 버블 정렬: 2, 삽입 정렬: 3) : ");
            String orderText = br.readLine();

            BasicSorts sortType = null;

            sortType = switch (orderText) {
                case "1" -> new SelectionSort();
                case "2" -> new BubbleSort();
                case "3" -> new InsertSort();
                default -> throw new IllegalArgumentException("지원하지 않는 정렬 방식입니다 : " + orderText);
            };

            int[] sortedArray = sortType.getSortedArray(arr);

            for (int element : sortedArray) {
                sb.append(element).append(" ");
            }

            System.out.print(sb);

        } catch (IOException | IllegalArgumentException e) {
            System.err.print("오류 발생: " + e.getMessage());
        }
    }
}

interface BasicSorts {
    int[] getSortedArray(int[] arr);
}

class SelectionSort implements BasicSorts {
    @Override
    public int[] getSortedArray(int[] arr) {
        int[] array = arr.clone();
        int lastIndex = array.length - 1;
        // 7 8 5 9
        while (lastIndex > 0) {
            int maxIndex = 0;
            for (int i = 1; i <= lastIndex; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            ArrayUtils.swap(array, maxIndex, lastIndex);
            lastIndex--;
        }
        return array;
    }
}

class BubbleSort implements BasicSorts {
    @Override
    public int[] getSortedArray(int[] arr) {
        int[] array = arr.clone();
        int len = array.length-1;
        boolean swapped = false;

        while (len > 0) {
            for (int i = 0; i < len; i++) {
                if (array[i] > array[i+1]) {
                    ArrayUtils.swap(array, i, i+1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
            len--;
        }
        return array;
    }
}

class InsertSort implements BasicSorts {
    @Override
    public int[] getSortedArray(int[] arr) {
        int[] array = arr.clone();
        for (int i = 1; i < array.length; i++) {
            int prev = i - 1;
            int curr = i;

            int temp = array[curr];
            while (array[prev] > temp) {
                array[curr] = array[prev];
                prev--;
                curr--;
                if(prev == -1){
                    break;
                }
            }
            array[prev+1] = temp;
        }
        return array;
    }
}

class ArrayUtils {
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
