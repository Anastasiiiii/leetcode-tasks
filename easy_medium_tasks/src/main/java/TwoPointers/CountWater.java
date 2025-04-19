package TwoPointers;

public class CountWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (start < end){
            int  area = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(max, area);
            if(height[start] < height[end]){
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
