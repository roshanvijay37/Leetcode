class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        generatePermutations(nums, used, currentPermutation, result);

        return result;
    }

    private void generatePermutations(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            // Base case: When the currentPermutation has reached the required length, add it to the result
            result.add(new ArrayList<>(currentPermutation));
        } else {
            // Recursive case: Generate permutations for the remaining unused elements
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    // Choose an unused element
                    used[i] = true;
                    currentPermutation.add(nums[i]);

                    // Recursively generate permutations for the remaining elements
                    generatePermutations(nums, used, currentPermutation, result);

                    // Backtrack: Remove the chosen element for the next iteration
                    used[i] = false;
                    currentPermutation.remove(currentPermutation.size() - 1);
                }
            }
        }
    }
}
