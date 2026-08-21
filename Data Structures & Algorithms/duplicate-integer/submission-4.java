class Solution { 
    public boolean hasDuplicate(int[] nums) { 
        Set<Integer> target = new HashSet<>(); 
        boolean dupe = false;

        for (int i = 0; i < nums.length; i++) {
            if (!target.contains(nums[i])) { 
                target.add(nums[i]);
            } else { 
                dupe = true;
            } 
        }
        return dupe; 

    } 
}