#include <stdlib.h>
#include<stdio.h>

//Swap helper function
void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

//Core implementation of the Dutch National Flag Technique
void dnf_sort(int arr[], int n){
    int low = 0, mid = 0, high = n - 1;
    while (mid <= high){
        if (arr[mid] == 0){
            swap(&arr[low], &arr[mid]);
            low++;
            mid++;
        }
        else if (arr[mid] == 1){
            mid++;
        }
        else{
            swap(&arr[mid], &arr[high]);
            high--;
        }
    }
    for (int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
}


int main(){
    int arr[] = {2, 0, 1, 2, 1, 0, 0, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    dnf_sort(arr, n);
    return 0;
}
