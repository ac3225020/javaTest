package heap;

public class KthElement {


    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 2;
        array[2] = 1;
        array[3] = 5;
        array[4] = 6;
        array[5] = 4;
        System.out.println(new KthElement().findKthLargest(array,2));


    }
}
