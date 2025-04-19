package BinarySearch;

public class UniqueElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

    private static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int answer = 0;

        while (start <= end){
            int mid = (start + end) / 2;
            if(mid < nums.length && nums[mid] == nums[mid + 1]){
                int leftLen = mid - start;
                if(leftLen % 2 == 0){
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                int leftLen = mid - 1 - start;
                if(leftLen % 2 == 0){
                    start = mid + 1;
                } else {
                    end = mid - 2;
                }
            }else {
                answer = nums[mid];
                break;
            }
        }
        return answer;
    }

}
