// Approach 1: Sorting the array

// This is fairly straight forward. If we simply sort the nums array, we can obtain the median by simply accessing the middle element. This allows us to find the median in O(nlogn) time. Keep in mind that if the array is of even length, we can just pick either of the two middle values as our median.

// Approach 2: Quick Select

// The sorting method is inefficient because it sorts the entire array. All we really need to do is put the median element where it's supposed to be; we don't care about where the other elements end up. Sound familiar? Well turns out we can do exactly that using quick select. In quick select, we'll just select the middle element; n/2 and retrieve the value at that position. This allows us to find the median element in O(n) time on average.

// If you're unfamiliar with quick select, I highly recommend reading this guide that I wrote which explains the entire process in detail, including explanations for time complexity.
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/solutions/2215782/visual-explanation-interview-tips-java

class Solution {
    public int minMoves2(int[] nums) {
	Arrays.sort(nums);
	int operations = 0, mid = nums[nums.length/2];
	for (int num: nums) operations += Math.abs(mid - num);
	return operations;
}
}
// class Solution {
//     public int minMoves2(int[] nums) {
//         int operations = 0, mid = quickSelect(nums, 0, nums.length-1, nums.length/2);
//         for (int num: nums) operations += Math.abs(mid - num);
//         return operations;
//     }
    
//     private int quickSelect(int[] nums, int left, int right, int k) {
//         if (left == right) return nums[left];

//         int pIndex = new Random().nextInt(right - left + 1) + left;
//         pIndex = partition(nums, left, right, pIndex);

//         if (pIndex == k) return nums[k];
//         else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
//         return quickSelect(nums, left, pIndex-1, k);
//     }

//     private int partition(int[] nums, int left, int right, int pIndex) {
//         int pivot = nums[pIndex];
//         swap(nums, pIndex, right);
//         pIndex = left;

//         for (int i=left; i<=right; i++) 
//             if (nums[i] <= pivot) swap(nums, i, pIndex++);

//         return pIndex - 1;
//     }

//     private void swap(int[] nums, int x, int y) {
//         int temp = nums[x];
//         nums[x] = nums[y];
//         nums[y] = temp;
//     }
// }
