public class lomutoPartition {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end], i = start - 1;
        for (int j = start; j < end; j++)
            if (arr[j] < pivot) swap(arr, ++i, j);
        swap(arr, i + 1, end);
        return i + 1;
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 56, 8, 75, 25, 22};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}

