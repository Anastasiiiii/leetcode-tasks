import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Task2 {
    public static void main(String[] args) {
        int[] students = {2, 2, 6, 6};
        int[] seats = {1, 3, 2, 6};
        int sum = sum(seats, students);
        System.out.println("Total moves were used: " + sum);

        int[] students1 = {3, 1, 5};
        int[] seats1 = {2, 7, 4};
        System.out.println("Total moves were used: " + minMovesToSeat(seats1, students1));

        int[] nums = {3,2,1,2,1,7};
        System.out.println("Min Increment for unique number " + minIncrementForUnique(nums));

        int x = 121;
        System.out.println("Palindrome number is: " + isPalindrome(x));

        int x1 = 1234;
        System.out.println("Palindrome number is: " + isPalindrome(x1));

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        System.out.println("Merged array: " + Arrays.toString(merge(nums1, 3, nums2, 3)));


        int[] nums3 = {1,2,3,0,0,0};
        int[] nums4 = {2,5,6};
        Task2 task2 = new Task2();
        task2.mergeElements(nums3, 3, nums4, 3);
        System.out.println("Merged array: " + Arrays.toString(nums3));

        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println("Next task");
        System.out.println(findMaximizedCapital(k, w, profits, capital));

        int k1 = 3;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 2};

        System.out.println("Next task");
        System.out.println(findMaximizedCapital(k, w, profits, capital));

        int[] nums_arr1 = {1, 2, 3, 5};
        int[] nums_arr2 = {2, 4, 6, 7};
        int[] nums_arr3 = {2, 9, 4, 5};
        System.out.println(Arrays.toString(mergeThreeArrays(nums_arr1, nums_arr2, nums_arr3)));


    }

    public static int dif(int[] seats, int[] students, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int st = students[n];
        for (int i = 0; i < seats.length; i++) {
            if(st > seats[i]){
                int move = st - seats[i];
                list.add(move);
            }
        }
        int min = Collections.min(list);
        return min;
    }

    public static int sum(int[] seats, int[] students) {
        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            int move = dif(seats, students, i);
            sum += move;
        }
        return sum;
    }

    public static int minMovesToSeat(int[] seats, int[] students){
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;

        for (int i = 0; i < students.length; i++) {
            sum += Math.abs(students[i] - seats[i]);
        }
        return sum;
    }
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] - nums[i] + 1;
                nums[i] += increment;
                n += increment;
            }
        }
        return n;
    }
    public static boolean isPalindrome(int x){
        int m;
        int k=0;
        int temp = x;
        while (temp > 0){
            m = temp % 10;
            temp /= 10;
            k = k * 10 + m;
        }
        System.out.println(k);
        System.out.println(x);
        if (k == x){
            return true;
        } else {
            return false;
        }
    }
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i+m] = nums2[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void mergeElements(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;

        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<Integer> list = new ArrayList<>();
        int p = profits[w];
        int m = 1;
        int limit = capital.length;
        while (k > 0) {
            for (int i = 0; i < limit; i++) {
                if(capital[i] == w){
                    list.add(i);
                }
                w++;
            }
            k--;
        }

        int maxNumber = Collections.max(list);
        System.out.println("Max number: " + maxNumber);
        System.out.println("List: " + list);

        int sum = 0;
        sum += w + p + profits[maxNumber];
        return sum;
    }

    private static int[] mergeThreeArrays(int[] nums1, int[] nums2, int[] nums3){
        int n = nums1.length;
        int m = nums2.length;
        int l = nums3.length;

        int[] nums = new int[n+m+l];
        for(int i = 0; i<n; i++){
            nums[i] = nums1[i];
        }
        for(int i = 0; i < m; i++){
            nums[i+n] = nums2[i];
        }
        for(int i = 0; i < l; i++){
            nums[i + n + m] = nums3[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    private static void mergedArrays(int[] nums1, int[] nums2, int[] nums3){
        int n = nums1.length - 1;
        int m = nums2.length - 1;
        int l = nums3.length - 1;

        int k = nums1.length + nums2.length + nums3.length - 1;
        while(n >=0 && m >=0 && l>=0){
            if(nums1[n] > nums2[m] && nums1[n] > nums3[l]) {

            }
        }
    }
}
