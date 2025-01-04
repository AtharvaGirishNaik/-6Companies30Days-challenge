class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort envelopes by width ascending and height descending
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Descending height for same width
            }
            return Integer.compare(a[0], b[0]); // Ascending width
        });

        // Step 2: Extract heights
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Step 3: Find LIS on heights using binary search
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, length, num);
            if (index < 0) {
                index = -(index + 1); // Convert to insertion point
            }
            dp[index] = num;
            if (index == length) {
                length++;
            }
        }

        return length;
    }
}
