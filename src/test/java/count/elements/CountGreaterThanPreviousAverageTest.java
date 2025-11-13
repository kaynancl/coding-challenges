package count.elements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGreaterThanPreviousAverageTest {

    @Test
    @DisplayName("Should return 0 for an empty array")
    void testEmptyArray() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of());
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 for a single-element array")
    void testSingleElement() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(100));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 2 for the sample case [100, 200, 150, 300]")
    void testSampleCase() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(100, 200, 150, 300));
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should return 0 when all elements are equal")
    void testAllEqualValues() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(100, 100, 100, 100));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 4 for a strictly increasing sequence")
    void testStrictlyIncreasing() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(10, 20, 30, 40, 50));
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Should return 0 for a strictly decreasing sequence")
    void testStrictlyDecreasing() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(500, 400, 300, 200, 100));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should handle large numbers without overflow")
    void testLargeNumbers() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(1_000_000_000, 1_000_000_000, 1_000_000_000));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 2 for alternating high and low values")
    void testAlternatingHighLow() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(100, 1000, 200, 1500, 300));
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should return 2 for sequence containing zeros")
    void testWithZeros() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(0, 0, 10, 0, 10));
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should correctly handle small numbers")
    void testSmallNumbers() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(List.of(1, 2, 1, 3, 2, 4));
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Should handle null input safely")
    void testNullArray() {
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(null);
        assertEquals(0, result);
    }
}

