# Dutch National Flag Algorithm
A partitioning-based sorting algorithm most commonly used to sort arrays with three distinct values (e.g., 0s, 1s, and 2s). While the standard implementation focuses on three values, the core idea can be generalized for k-way partitioning in more complex scenarios.

## Problem Setup :
We are given an array consisting of exactly three distinct values (for example: 0, 1, and 2). The goal is to sort this array in-place, grouping all occurrences of the same value together without using extra space.
### Naive Approach (For Comparison)
A basic solution involves counting occurrences of each value and then overwriting the array in a second pass. This is simple but requires multiple passes over the data.
### Efficient Approach: Dutch National Flag Algorithm
This algorithm partitions the array into three sections using three pointers in a single pass.
NOTE : The algorithmic logic is similar, but the implementation details reflect the strengths and limitations of each language
### Dry Run Test Case
``` Step 0: Initial State
[2, 0, 1, 2, 1, 0, 0, 2]
 L  M                 H

Step 1: arr[M] == 2 → swap(M, H), high--
[2, 0, 1, 2, 1, 0, 0, 2]
 L  M              H

Step 2: arr[M] == 2 → swap(M, H), high--
[0, 0, 1, 2, 1, 0, 2, 2]
 L  M           H

Step 3: arr[M] == 0 → swap(L, M), low++, mid++
[0, 0, 1, 2, 1, 0, 2, 2]
    L  M        H

Step 4: arr[M] == 0 → swap(L, M), low++, mid++
[0, 0, 1, 2, 1, 0, 2, 2]
       L  M     H

Step 5: arr[M] == 1 → mid++
[0, 0, 1, 2, 1, 0, 2, 2]
       L     M  H

Step 6: arr[M] == 2 → swap(M, H), high--
[0, 0, 1, 0, 1, 2, 2, 2]
       L     M  H

Step 7: arr[M] == 0 → swap(L, M), low++, mid++
[0, 0, 1, 0, 1, 2, 2, 2]
          L  M H

Step 8: arr[M] == 1 → mid++
[0, 0, 1, 0, 1, 2, 2, 2]
          L     M H

Done: mid > high
Final sorted array:
[0, 0, 0, 1, 1, 2, 2, 2]
```
### Computational Complexity
Time Complexity : O(n)<br>
Space Complexity : O(1)
