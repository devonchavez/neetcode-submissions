//return k most frequent elements within the array.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //create a hashmap to store the count of each number in the list
        HashMap<Integer, Integer> totalCount = new HashMap<Integer, Integer>();
        
        //traverse through the list of numbers
        for (int i=0; i<nums.length; i++){
            //create a conditional to count the total number of elements
            if (totalCount.containsKey(nums[i])){
                //if the key exists for that number within the array increment the total count
                int curCount = totalCount.get(nums[i]);
                curCount++;
                totalCount.put(nums[i], curCount);
            } else {
                //if the key doesnt exist, add it in the hashmap
                totalCount.put(nums[i], 1);
            }
        }
    

        //create class list to store the elements grouped where the frequency is associated with its index
        List<Integer>[] freqBuc = new List[nums.length + 1];

        //create the newArr to return 
        int[] newArr = new int[k];

        //traverse the hashmap
        for (int num: totalCount.keySet()){
            //create the index to see if a list exists for that k frequent element
            int frequency = totalCount.get(num);
        
            //if a list for that keys frequency doesnt exist create a new list
            if(freqBuc[frequency] == null){
                freqBuc[frequency] = new ArrayList<Integer>();
            } 
            freqBuc[frequency].add(num);
        }

        int index = 0;
        //traverse this 2d array that tracks frequency -> key
        for (int frequency=freqBuc.length-1; frequency>=0; frequency--){        
            //if the list at that frequency exists go into that nested list
            if (freqBuc[frequency] != null){
                //traverse the nested list
                //we already know were dealing with a frequency that is within k since were starting from the bottom of the outer list aka most frequent numbers
                for(int num: freqBuc[frequency]){

                    newArr[index] += num;
                    index++;
                    //
                    if(index >= k){
                        return newArr;
                    }
                }
            }
  
        }

        return newArr;

    }

}

