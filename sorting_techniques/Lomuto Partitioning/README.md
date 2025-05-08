# Lomuto Partition Algorithm
The Lomuto partition is a technique used in Quick Sort algorithm and it divides an array based on a pivot element. One pointer marks the boundary for elements smaller than the pivot, while the other pointer helps in array traversal. The last element is assumed to be the pivot.

## Problem Setup :
We are given an array and the task is to partition the array by assuming last element as pivot element.
The partition must also satisfy the following conditions:
- Elements smaller than the pivot element appear before pivot in the array.
- Elements larger than or equal to the pivot element appear after pivot it in the array.

### Dry Run Test Case
```Initial Array: [12, 56, 8, 75, 25, 22]
L          M                 H

Step 1: Partition from 0 to 5
Pivot = 22, i = -1

| j  | arr[j] | arr[j] < 22  | Action                           | Array after operation       | L  | M | H  | i |
|----|--------|--------------|----------------------------------|-----------------------------|----|---|----|---|
| 0  | 12     | Yes          | i++, swap arr[0] with arr[0]     | [12, 56, 8, 75, 25, 22]      | 0  | 0 | 5  | 0 |
| 1  | 56     | No           | -                                | [12, 56, 8, 75, 25, 22]      | 0  | 1 | 5  | 0 |
| 2  | 8      | Yes          | i++, swap arr[1] with arr[2]     | [12, 8, 56, 75, 25, 22]      | 0  | 2 | 5  | 1 |
| 3  | 75     | No           | -                                | [12, 8, 56, 75, 25, 22]      | 0  | 3 | 5  | 1 |
| 4  | 25     | No           | -                                | [12, 8, 56, 75, 25, 22]      | 0  | 4 | 5  | 1 |

After loop, swap arr[i+1] with arr[5] → swap arr[2] and arr[5]

Result after partition:
[12, 8, 22, 75, 25, 56]
Pivot index = 2
L          M           H

Step 2: QuickSort on left partition (0 to 1)
Partition from 0 to 1
Pivot = 8, i = -1

| j  | arr[j] | arr[j] < 8   | Action                           | Array after operation       | L  | M | H  | i |
|----|--------|--------------|----------------------------------|-----------------------------|----|---|----|---|
| 0  | 12     | No           | -                                | [12, 8, 22, 75, 25, 56]      | 0  | 0 | 1  | -1 |
| 1  | 8      | Yes          | i++, swap arr[0] with arr[1]     | [8, 12, 22, 75, 25, 56]      | 0  | 1 | 1  | 0 |

Base case: `quick_sort(arr, 0, -1)` and `quick_sort(arr, 1, 1)` return as L >= H.

Step 3: QuickSort on right partition (3 to 5)
Partition from 3 to 5
Pivot = 56, i = 2

| j  | arr[j] | arr[j] < 56  | Action                           | Array after operation       | L  | M | H  | i |
|----|--------|--------------|----------------------------------|-----------------------------|----|---|----|---|
| 3  | 75     | No           | -                                | [8, 12, 22, 75, 25, 56]      | 3  | 3 | 5  | 2 |
| 4  | 25     | Yes          | i++, swap arr[3] with arr[4]     | [8, 12, 22, 25, 75, 56]      | 3  | 4 | 5  | 3 |
| 5  | 56     | No           | -                                | [8, 12, 22, 25, 75, 56]      | 3  | 5 | 5  | 3 |

After loop, swap arr[i+1] with arr[5] → swap arr[4] and arr[5]

Result after partition:
[8, 12, 22, 25, 56, 75]
Pivot index = 4
L          M              H

Step 4: QuickSort on left partition (3 to 3)
Base case: `quick_sort(arr, 3, 3)` returns (L == H).

Step 5: QuickSort on right partition (5 to 5)
Base case: `quick_sort(arr, 5, 5)` returns (L == H).

Final Sorted Array:
[8, 12, 22, 25, 56, 75]
```

### Computational Complexity
Time Complexity : O(n^2)<br>
Space Complexity : O(log n)

