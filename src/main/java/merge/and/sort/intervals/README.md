# Merge and Sort Intervals

## Problem Description

Given an array of intervals `[startTime, endTime]`, merge all **overlapping intervals** and return a **sorted array of non-overlapping intervals**.

If two intervals overlap (that is, the start of one is less than or equal to the end of the previous), they should be merged into a single interval.
If they do not overlap, keep them separate. The final result should be sorted by start time in ascending order.

---

## Example

### Input

intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]

### Output

[[1, 6], [8, 10], [15, 18]]

### Explanation

* **Step 1:** Sort intervals by start time (already sorted).
* **Step 2:** Initialize merged list with first interval `[1, 3]`.
* **Step 3:** Compare `[2, 6]` with last merged `[1, 3]`. They overlap (2 ≤ 3), so merge into `[1, 6]`.
* **Step 4:** Compare `[8, 10]` with last merged `[1, 6]`. No overlap (8 > 6), append `[8, 10]`.
* **Step 5:** Compare `[15, 18]` with last merged `[8, 10]`. No overlap (15 > 10), append `[15, 18]`.

**Result:** [[1, 6], [8, 10], [15, 18]]

---

## Input Format

* The first line contains an integer `n`, the number of intervals.
* The second line contains an integer representing the length of each individual interval array (always `2`).
* Each of the next `n` lines contains two space-separated integers: `startTime` and `endTime`.
* Intervals may be provided in **any order**; duplicates and fully contained intervals are allowed.

### Example

4
2
1 3
2 6
8 10
15 18

Here,
`4` is the number of intervals,
`2` is the length of each interval,
followed by the list of intervals.

---

## Constraints

* 0 ≤ `intervals.length` ≤ 100000
* `intervals[i].length == 2` for all valid `i`
* 0 ≤ `intervals[i][0]` < `intervals[i][1]` ≤ 10⁹

---

## Output Format

Return a 2D array (list of lists) of integers, where each sub-array contains two space-separated integers `start` and `end`, representing the **merged intervals**, sorted by increasing start time.

---

## Sample Test Cases

### Sample Input 0

0
0

### Sample Output 0

(empty output)

---

### Sample Input 1

1
2
5 10

### Sample Output 1

5 10

---

### Sample Input 2

4
2
1 3
2 6
8 10
15 18

### Sample Output 2

1 6
8 10
15 18

---

## Function Signature (Example in Python)

```java
public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals){
    
}
```
