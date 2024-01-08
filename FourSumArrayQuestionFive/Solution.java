class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> solutionListOfLists = new ArrayList<>();

        Arrays.sort(nums); // Sort the array to simplify the solution

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        solutionListOfLists.add(quadruplet);

                        // Move left and right pointers to find different combinations
                        left++;
                        right--;

            // Duplicate Removal
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            // Duplicate Removal
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            // Duplicate Removal
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return solutionListOfLists;
    }
}