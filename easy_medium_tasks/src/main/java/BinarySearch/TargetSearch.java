package BinarySearch;

public class TargetSearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
