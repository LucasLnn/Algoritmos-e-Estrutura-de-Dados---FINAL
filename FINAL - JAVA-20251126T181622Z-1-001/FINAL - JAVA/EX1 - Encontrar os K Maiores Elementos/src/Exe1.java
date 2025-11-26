import java.util.*;

public class Exe1 {

    public static List<Integer> findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(heap);
        result.sort(Collections.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 7, 2, 8};
        int k = 3;

        List<Integer> maiores = findKthLargest(arr, k);
        System.out.println(maiores);
    }
}
   