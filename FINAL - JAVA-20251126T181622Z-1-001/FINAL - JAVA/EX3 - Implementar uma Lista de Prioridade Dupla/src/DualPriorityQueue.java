import java.util.*;

public class DualPriorityQueue {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Map<Integer, Integer> freq = new HashMap<>();

    private void addFreq(int v) {
        freq.put(v, freq.getOrDefault(v, 0) + 1);
    }

    private void removeFreq(int v) {
        freq.put(v, freq.get(v) - 1);
        if (freq.get(v) == 0) freq.remove(v);
    }

    private void cleanMin() {
        while (!minHeap.isEmpty() && !freq.containsKey(minHeap.peek())) {
            minHeap.poll();
        }
    }

    private void cleanMax() {
        while (!maxHeap.isEmpty() && !freq.containsKey(maxHeap.peek())) {
            maxHeap.poll();
        }
    }

    public void insert(int value) {
        minHeap.add(value);
        maxHeap.add(value);
        addFreq(value);
    }

    public Integer getMin() {
        cleanMin();
        return minHeap.isEmpty() ? null : minHeap.peek();
    }

    public Integer getMax() {
        cleanMax();
        return maxHeap.isEmpty() ? null : maxHeap.peek();
    }

    public Integer removeMin() {
        cleanMin();
        if (minHeap.isEmpty()) return null;
        int v = minHeap.poll();
        removeFreq(v);
        return v;
    }

    public Integer removeMax() {
        cleanMax();
        if (maxHeap.isEmpty()) return null;
        int v = maxHeap.poll();
        removeFreq(v);
        return v;
    }

    public static void main(String[] args) {
        DualPriorityQueue dpq = new DualPriorityQueue();

        dpq.insert(5);
        dpq.insert(1);
        dpq.insert(9);
        dpq.insert(3);

        System.out.println(dpq.getMin());
        System.out.println(dpq.getMax());
        System.out.println(dpq.removeMin());
        System.out.println(dpq.removeMax());
        System.out.println(dpq.getMin());
        System.out.println(dpq.getMax());
    }
}
