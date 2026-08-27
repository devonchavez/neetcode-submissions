class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        Input: nums = [1,2,4,6]
            nums[0] = 2 * 4 * 6
            nums[1] = 4 * 6 * 1
            nums[2] = 6 * 1 * 2
            nums[3] = 1 * 2 * 4
        Output: [48,24,12,8]

        edge case could be the first and last index of the list of nums

        */

        //create list to add product nums into 
        int[] res = new int[nums.length];
        
        //Traverse the array and calculate the product of elements left of each index
        int pref = 1;
        for (int i=0; i<nums.length; i++) {
            res[i] = pref;
            pref *= nums[i];
        }

        //Calculate everything to the right of each index and multiply it into the result
        int post = 1;
        for (int j=nums.length - 1; j>=0; j--){
            res[j] *= post;
            post *= nums[j];
        }

        return res;
    }
}
