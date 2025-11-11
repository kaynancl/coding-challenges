package relative.distance;

import java.util.*;

class RelativeDistance {

    private Map<String, List<String>> familyTree;

    RelativeDistance(Map<String, List<String>> familyTree) {
        this.familyTree = buildGraph(familyTree);
    }

    public int degreeOfSeparation(String personA, String personB) {
        if (personA == null || personB == null) return -1;
        if (personA.equals(personB)) return 0;

        if (!familyTree.containsKey(personA) || !familyTree.containsKey(personB)) return -1;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distanceMap = new HashMap<>();

        queue.add(personA);
        distanceMap.put(personA, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            Integer distance = distanceMap.get(current);

            if (current.equals(personB)) {
                return distance;
            }

            for (String neighbor : familyTree.get(current)) {
                if (!distanceMap.containsKey(neighbor)) {
                    distanceMap.put(neighbor, distance + 1);
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }

    public Map<String, List<String>> buildGraph(Map<String, List<String>> familyTree) {
        Map<String, List<String>> graph = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();
            graph.putIfAbsent(parent, new ArrayList<>());
            for (String child : children) {
                graph.putIfAbsent(child, new ArrayList<>());
                graph.get(parent).add(child);
                graph.get(child).add(parent);

//                Siblings
                graph.get(child).addAll(children);
                graph.get(child).remove(child);
            }
        }
        return graph;
    }
}
