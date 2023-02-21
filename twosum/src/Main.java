import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    //brute-force solution. O(n^2) time | O(1) space
    public static int[] twoSum(int[] nums, int target) {
        // Create an array to hold the indices of the two numbers that add up to the target
        int[] indices = new int[2];

        // Loop through each element of the array exactly once
        for(int i = 0; i < nums.length; i++){
            int firstNum = nums[i];

            // Loop through the remaining elements of the nums array
            // Each inner loop has one fewer iteration than the previous one
            for(int j = 1+i; j < nums.length; j++){
                int secondNum = nums[j];
                if(firstNum + secondNum == target){
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    // O(n) time | O(n) space
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            //x+y = target
            int y = target - currentElement;

            //if "y" is already a stored key in the Map,
            if (map.containsKey(y)) {
                //get() returns value of the key, and "i" is the index of current element
                return new int[] { map.get(y), i };
            } else {
                //Add the current element as a key, and it's index as a value to the Map.
                map.put(currentElement, i);
            }
        }

        return new int[0];
    }

    //O(nLog(n)) time | O(1) space
    public static int[] twoSum3(int[] array, int targetSum) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) {
                return new int[] {left, right};
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        */

        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); //output: [0,1]

        int[] nums2 = {3,2,4};
        int target2 = 6;

        //sorting is used before calling the twoSum3() function
        //Arrays.sort(nums2);

        System.out.println(Arrays.toString(twoSum(nums2, target2))); //output: [1,2]

        int[] nums3 = {3,3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); //output: [0,1]
    }
}