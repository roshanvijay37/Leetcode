public class MedianOfTwoSortedArrays {

    // Function to find the median of two sorted arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // Lengths of the two arrays
        int x = nums1.length;
        int y = nums2.length;

        // Binary search on the smaller array
        int low = 0;
        int high = x;

        while (low <= high) {
            // Partition points for both arrays
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Values at the partition points and their adjacent elements
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we found the correct partition
            if (maxX <= minY && maxY <= minX) {
                // Check if the combined array has even or odd length
                if ((x + y) % 2 == 0) {
                    // If even, return the average of the max of left half and min of right half
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    // If odd, return the max of the left half
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Adjust partitionX to the left
                high = partitionX - 1;
            } else {
                // Adjust partitionX to the right
                low = partitionX + 1;
            }
        }

        // If the input arrays are not sorted, throw an exception
        throw new IllegalArgumentException("Input arrays are not sorted!");
    }
}
