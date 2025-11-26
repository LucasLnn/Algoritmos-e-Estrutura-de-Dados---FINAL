public class Exe4 {

    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[i] > arr[left]) return false;
            if (right < n && arr[i] > arr[right]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 8};
        int[] arr2 = {2, 10, 4, 15, 12, 8};

        System.out.println(isMinHeap(arr1));
        System.out.println(isMinHeap(arr2));
    }
}
