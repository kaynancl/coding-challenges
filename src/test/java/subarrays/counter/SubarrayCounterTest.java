package subarrays.counter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubarrayCounterTest {

    @Test
    @DisplayName("Example Test Case from Problem Statement")
    void testExampleCase() {
        List<Integer> nums = List.of(2, -1, 2, 1, -2, 3);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 3, 2);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Empty Array")
    void testEmptyArray() {
        List<Integer> nums = List.of();
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 0, 0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Single Element Equals k and <= M")
    void testSingleValidElement() {
        List<Integer> nums = List.of(5);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 5, 5);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Single Element Equals k but > M (Invalid)")
    void testSingleInvalidElement() {
        List<Integer> nums = List.of(5);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 5, 3);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("No Subarray Reaches Sum k")
    void testNoMatchingSum() {
        List<Integer> nums = List.of(1, 2, 3);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 10, 5);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("All Elements Valid but Only Some Subarrays Sum to k")
    void testSomeValidSubarrays() {
        List<Integer> nums = List.of(1, 1, 1, 1);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 2, 5);
        assertEquals(3, result); // [1,1] at indices (0,1), (1,2), (2,3)
    }

    @Test
    @DisplayName("Subarrays Blocked by Elements > M")
    void testBlockedByMaximum() {
        List<Integer> nums = List.of(1, 2, 10, 2, 1);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 3, 5);
        assertEquals(2, result); // Only subarrays [1,2] and [2,1]
    }

    @Test
    @DisplayName("Contains Negative Numbers")
    void testWithNegativeValues() {
        List<Integer> nums = List.of(3, -1, 1, 2, -2, 2);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 3, 3);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Large M That Does Not Restrict Subarrays")
    void testLargeM() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 6, 100);
        assertEquals(1, result); // [2,3,1] does not exist; only [2,4]? No. Real is [1,2,3] = 6
    }

    @Test
    @DisplayName("All Subarrays Valid Because All Elements <= M")
    void testAllElementsWithinBound() {
        List<Integer> nums = List.of(2, 2, 2);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 4, 5);
        assertEquals(2, result); // [2,2] starting at 0 and 1
    }

    @Test
    @DisplayName("Multiple Disconnected Valid Regions Split by Elements > M")
    void testMultipleRegions() {
        List<Integer> nums = List.of(1, 2, 9, 1, 2, 1, 10, 1, 2);
        long result = SubarrayCounter.countSubarraysWithSumAndMaxAtMost(nums, 3, 5);
        assertEquals(4, result);
        // Regions: [1,2], [1,2], [2,1], [1,2]
    }
}

