public class DnfSort {
    public static void main(String[] args) {
        int[] arr = { 2, 0, 1, 2, 1, 0, 0, 2 };
        dnfSort(arr);
    }

    public static void dnfSort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low++, mid++);
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high--);
            }
        }
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
