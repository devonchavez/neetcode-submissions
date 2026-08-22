class Solution {

    public String encode(List<String> strs) {
        //Create a stringbuilder that is able to put the list into a string
        StringBuilder res = new StringBuilder();

        //traverse through the array the code will be made up of the strings length, # and the string itself
        for (String s : strs){
            //[Hello, World] = 5#Hello5#World
            res.append(s.length()).append("#").append(s);
        }

        //return the class as a primitive type
        return res.toString();
    }

//use double pointers to build string back? 
    public List<String> decode(String str) {
        //create our poitners
        int i = 0;
        int j;

        //list of strings we are returning and building back into 
        ArrayList<String> res = new ArrayList<String>();

        //
        while (i < str.length()){
            j = i;

            while ('#' != str.charAt(j)){
                j++;
            }           
            
            String subString = str.substring(i,j);
            int length = Integer.parseInt(subString);
            int start = j + 1;
            int end = length + j + 1;

            String word = str.substring(start, end);
            res.add(word);

            i = end;
        }

        return res;
    }
}
