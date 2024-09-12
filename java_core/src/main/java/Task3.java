import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(Arrays.toString(removeElement(nums, val)));
    }
    public static int[] removeElement(int[] nums, int val) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                newNums[i] = nums[i];
            } else {
                newNums[i] = 0;
            }
        }
        Arrays.sort(newNums);

        return newNums;
    }
}
