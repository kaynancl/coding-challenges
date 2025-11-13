package count.elements;

import java.util.List;

public class CountGreaterThanPreviousAverage {

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if (responseTimes == null || responseTimes.isEmpty()) {
            return 0;
        }

        final int n = responseTimes.size();
        long sum = 0L;
        int count = 0;

        for (int i = 1; i < n; i++) {
            sum += responseTimes.get(i - 1);
            if (responseTimes.get(i) > (double) sum / i) {
                count++;
            }
        }
        return count;
    }

}
