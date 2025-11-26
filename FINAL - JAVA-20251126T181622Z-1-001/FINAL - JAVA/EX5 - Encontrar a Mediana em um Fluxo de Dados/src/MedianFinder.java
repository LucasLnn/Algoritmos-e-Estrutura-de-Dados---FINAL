import java.util.*;

public class MedianFinder {

    private PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> upper = new PriorityQueue<>();

    public void addNum(int num) {
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.add(num);
        } else {
            upper.add(num);
        }

        if (lower.size() > upper.size() + 1) {
            upper.add(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.add(upper.poll());
        }
    }

    public double findMedian() {
        if (lower.size() == upper.size()) {
            return (lower.peek() + upper.peek()) / 2.0;
        } else {
            return lower.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(5);
        mf.addNum(2);
        mf.addNum(10);
        mf.addNum(1);

        System.out.println(mf.findMedian());
    }
}
