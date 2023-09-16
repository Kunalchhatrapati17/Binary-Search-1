/*Search in sorted unknown Array
Time complexity:- O(log n)
  Space Complexity:- O(1)*/
class Solution {
    public int search(ArrayReader reader, int target) {
        // Initialize the search range
        int left = 0;
        int right = 1;

        // Expand the search range until finding an upper bound
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        // Perform binary search within the found range
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = reader.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    }
}
