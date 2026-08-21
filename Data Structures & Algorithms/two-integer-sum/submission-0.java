class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Create hashmap
        Map<Integer, Integer> twoSum = new HashMap<>();
        
        //create new arr which stores the sum
        int[] newArr = new int[2];

        //traverse array
        for (int i = 0; i < nums.length; i++){
           
           //calculate one of the terms of the sum
            int diff = target - nums[i];

            if (twoSum.containsKey(diff)){
                newArr[0] = twoSum.get(diff);
                newArr[1] = i;
                return newArr;
            } else {
                twoSum.put(nums[i] , i);
            }     

        }

        return newArr;
    }
}
