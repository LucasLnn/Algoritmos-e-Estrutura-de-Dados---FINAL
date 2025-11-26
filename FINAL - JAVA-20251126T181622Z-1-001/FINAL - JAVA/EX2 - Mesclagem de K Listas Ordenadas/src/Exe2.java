import java.util.*;

public class Exe2 {

    static class Node implements Comparable<Node> {
        int value;
        int listIndex;
        int elementIndex;

        Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                heap.add(new Node(lists.get(i).get(0), i, 0));
            }
        }

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            result.add(current.value);

            int nextIndex = current.elementIndex + 1;
            if (nextIndex < lists.get(current.listIndex).size()) {
                int nextValue = lists.get(current.listIndex).get(nextIndex);
                heap.add(new Node(nextValue, current.listIndex, nextIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 4, 5));
        lists.add(Arrays.asList(1, 3, 4));
        lists.add(Arrays.asList(2, 6));

        System.out.println(mergeKSortedLists(lists));
    }
}
