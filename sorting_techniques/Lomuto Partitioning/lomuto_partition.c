#include <stdio.h>

// Swap helper
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Lomuto partition technique
int lomuto_partition(int arr[], int start, int end) {
    int pivot = arr[end];
    int i = start - 1;

    for (int j = start; j < end; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[end]);
    return i + 1;
}

// quicksort using Lomuto partition
void quick_sort(int arr[], int start, int end) {
    if (start < end) {
        int p = lomuto_partition(arr, start, end);
        quick_sort(arr, start, p - 1);
        quick_sort(arr, p + 1, end);
    }
}

int main() {
    int arr[] = {12, 56, 8, 75, 25, 22};
    int n = sizeof(arr) / sizeof(arr[0]);

    quick_sort(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
