class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] returnArray = {-1, -1};

        // Search for the start index
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        // If the target is not found, return {-1, -1}
        if (start == -1) {
            return returnArray;
        }

        // Search for the end index
        int end = start;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                end = i;
            } else {
                break; // Break the loop when a different element is encountered
            }
        }

        returnArray[0] = start;
        returnArray[1] = end;
        return returnArray;
    }
}