import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //Question is If we get a array of numbers nums[] with some number
        //We should return all the possible triplets in nums[] such that nums[i]+nums[j]+nums[k] = 0
        //Example {-1, 0, 1}
        //We start solving this by sorting the array and taking target = -nums[i]
        //i.e if nums[i] = 5 then target is -5
        //We initialize left = 0 and right = nums.length - 1
        //As long as left<right we add we traverse through all the entries of the nums array
        //If target+nums[left]+nums[right] == 0, Add (nums[i],nums[left],nums[right]) to our solutionlistOfLists
        //If num[left] and nums[left+1] are same we make left++
        //likewise If nums[right] and nums[right - 1] are same we make right--;
        //This is because, We don't want duplicate entries in our solution
        //Make left++ and right-- This is because if target+nums[left]+nums[right] == 0, We have already added it to the solutionListOfLists
        //And we want to shift both the pointers left and right by 1 bit each
        //if target is less than nums[left]+nums[right] We make left++
        //Likewise if target is greater than nums[left]+nums[right] we make right--
        List<List<Integer>> solutionListOfLists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            int left = i+1;
            int right = nums.length - 1;
            while(left<right)
            {
                int sum = nums[left]+nums[right];
                int target = -nums[i];
                if((sum == target))
                {
                    solutionListOfLists.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    while(left<right && (nums[left] == nums[left+1]))
                        left++;

                    while(left<right && (nums[right-1] == nums[right]))
                        right--;

                    left++;
                    right--;
                }
                else if(target>sum)
                    left++;
                else
                    right--;
            }
        }
        return (solutionListOfLists);
    }
    public static void main(String args[])
    {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> answerList = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(answerList);
    }
}
