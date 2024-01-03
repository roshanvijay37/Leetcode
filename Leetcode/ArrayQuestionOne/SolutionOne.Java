class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            //Iterating i from j+1 so that I avoid duplicate pairs, Like nums[i],nums[j]
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                    return new int[]{i, j};
            }
        }
    }
}