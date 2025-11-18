package subarrays.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayCounter {

    public static long countSubarraysWithSumAndMaxAtMost(List<Integer> nums, long k, long M) {
        if (nums.isEmpty()) return 0;
        long count = 0;

        int n = nums.size();
        int start = 0;

        while (start < n) {
            if (nums.get(start) > M) {
                start++;
                continue;
            }

            int end = start;
            while (end < n && nums.get(end) <= M) {
                end++;
            }
            count += countSubarraysWithSum(nums, start, end, k);
            start = end;
        }

        return count;
    }

    private static long countSubarraysWithSum(List<Integer> nums, int start, int end, long k) {
        Map<Long, Long> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1L);

        long prefix = 0;
        long count = 0;

        for (int i = start; i < end; i++) {
            prefix += nums.get(i);
            count += prefixCount.getOrDefault(prefix - k, 0L);
            prefixCount.put(prefix, prefixCount.getOrDefault(prefix, 0L) + 1);
        }
        return count;
    }
}
