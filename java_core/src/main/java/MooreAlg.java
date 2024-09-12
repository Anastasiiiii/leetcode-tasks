public class MooreAlg {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 3, 3, 4, 5};
        int maj = majorityElement(nums);
        System.out.println(maj);
    }
    private static int majorityElement(int[] nums){
        int count = 0;
        Integer k = null; //current candidate to think as a majority element

        for (int num : nums) {
            if(count == 0){
                k = num;
            }
            count += (num == k) ? 1 : -1;
        }
        return k;
    }

}
