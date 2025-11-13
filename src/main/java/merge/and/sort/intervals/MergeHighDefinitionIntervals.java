package merge.and.sort.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeHighDefinitionIntervals {

    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<>();
        }
        if (intervals.size() == 1) {
            return new ArrayList<>(intervals);
        }

        // Make a mutable copy before sorting
        intervals = new ArrayList<>(intervals);

        // Sort by the start value (first element)
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<List<Integer>> mergedList = new ArrayList<>();
        mergedList.add(new ArrayList<>(intervals.get(0)));

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> lastMerged = mergedList.get(mergedList.size() - 1);
            List<Integer> current = intervals.get(i);

            int lastEnd = lastMerged.get(1);
            int currentStart = current.get(0);
            int currentEnd = current.get(1);

            if (currentStart <= lastEnd) {
                // Merge overlapping intervals
                lastMerged.set(1, Math.max(lastEnd, currentEnd));
            } else {
                // Add as a new interval
                mergedList.add(new ArrayList<>(current));
            }
        }

        return mergedList;
    }

}
