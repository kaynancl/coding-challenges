package merge.and.sort.intervals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeHighDefinitionIntervalsTest {

    @Test
    @DisplayName("Should return empty list for empty input")
    void testEmptyInput() {
        List<List<Integer>> intervals = List.of();
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should return the same single interval when only one is provided")
    void testSingleInterval() {
        List<List<Integer>> intervals = List.of(List.of(5, 10));
        List<List<Integer>> expected = List.of(List.of(5, 10));
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should correctly merge overlapping intervals")
    void testOverlappingIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(1, 3),
                List.of(2, 6),
                List.of(8, 10),
                List.of(15, 18)
        );
        List<List<Integer>> expected = List.of(
                List.of(1, 6),
                List.of(8, 10),
                List.of(15, 18)
        );
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should merge nested intervals correctly")
    void testNestedIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(1, 10),
                List.of(2, 5),
                List.of(3, 7)
        );
        List<List<Integer>> expected = List.of(List.of(1, 10));
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should keep disjoint intervals unchanged")
    void testDisjointIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        List<List<Integer>> expected = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should correctly handle unordered intervals by sorting first")
    void testUnorderedIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(8, 10),
                List.of(1, 3),
                List.of(2, 6),
                List.of(15, 18)
        );
        List<List<Integer>> expected = List.of(
                List.of(1, 6),
                List.of(8, 10),
                List.of(15, 18)
        );
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should merge intervals that touch at boundaries (inclusive)")
    void testTouchingIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(1, 3),
                List.of(3, 5),
                List.of(5, 7)
        );
        List<List<Integer>> expected = List.of(List.of(1, 7));
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should handle duplicate intervals correctly")
    void testDuplicateIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(1, 4),
                List.of(1, 4),
                List.of(2, 3)
        );
        List<List<Integer>> expected = List.of(List.of(1, 4));
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return empty list for null input")
    void testNullInput() {
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(null);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should handle intervals with large values")
    void testLargeValues() {
        List<List<Integer>> intervals = List.of(
                List.of(0, 1_000_000_000),
                List.of(500_000_000, 1_000_000_001)
        );
        List<List<Integer>> expected = List.of(List.of(0, 1_000_000_001));
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should merge partially overlapping intervals")
    void testPartiallyOverlappingIntervals() {
        List<List<Integer>> intervals = List.of(
                List.of(1, 5),
                List.of(4, 6),
                List.of(6, 8)
        );
        List<List<Integer>> expected = List.of(List.of(1, 8));
        List<List<Integer>> result = MergeHighDefinitionIntervals.mergeHighDefinitionIntervals(intervals);
        assertEquals(expected, result);
    }
}

