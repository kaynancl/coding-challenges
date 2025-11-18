# Subarrays with Given Sum and Bounded Maximum

Given an integer array `nums` and integers `k` and `M`, count the number of contiguous subarrays whose sum equals `k` **and** whose maximum element is at most `M`.

---

### Explanation

We need subarrays with sum = 3 and all elements ≤ 2.
Any subarray containing the value `3` is invalid because `3 > M`.

Checking all starting positions:

* From index 0: `[2, -1, 2]` → sum = 3, max = 2 → **valid** (count = 1)
* From index 2: `[2, 1]` → sum = 3, max = 2 → **valid** (count = 2)

No other subarrays qualify.
Total = **2**.

---

## Function Signature

```java
public static long countSubarraysWithSumAndMaxAtMost(List<Integer> nums, long k, long M) {}
````

**Parameters:**

* `nums`: List of integers representing the array.
* `k`: Target sum for the subarray.
* `M`: Maximum allowed value within the subarray.

**Returns:**
A non-negative `long` representing the number of valid contiguous subarrays.

---

## Constraints

```
0 <= nums.length <= 1,000,000
-10^9 <= nums[i] <= 10^9
-10^15 <= k <= 10^15
-10^9 <= M <= 10^9
```

---

## Example

### Input

```text
nums = [2, -1, 2, 1, -2, 3]
k = 3
M = 2
```

### Output

```text
2
```