import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
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
