class Solution {
    public boolean isAnagram(String s, String t) {
        int i;
        boolean isAnagram = false;

        //creating empty hashtables to place characters of strings into
        Hashtable<Character, Integer> freqMapS = new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> freqMapT = new Hashtable<Character, Integer>();

        //checknig if lengths of the strings are different and returning false if true 
        if (s.length() != t.length()){
            return false;
        }

        //looping through the contents of string S and 
        for (i = 0; i < s.length(); i++){
            int counterS = 1;
            char charS = s.charAt(i);
            if (freqMapS.containsKey(charS)){
                int existingSCount = freqMapS.get(charS);
                int newCountS = existingSCount + 1;
                freqMapS.put(charS, newCountS);
            } else {
                freqMapS.put(charS, counterS);
            }
        }

        for (i = 0; i < t.length(); i++){
            char charT = t.charAt(i);
            int counterT = 1;
            if (freqMapT.containsKey(charT)){
                int existingTCount = freqMapT.get(charT);
                int newCountT = existingTCount + 1;
                freqMapT.put(charT, newCountT);
            } else {
                freqMapT.put(charT, counterT);
            }
        }  

        for (Map.Entry<Character, Integer> e : freqMapS.entrySet()){
            Character keyS = e.getKey();
            Integer countS = e.getValue();

            if (freqMapT.containsKey(keyS)){
                Integer countT = freqMapT.get(keyS);
                if (countT.equals(countS)){
                    isAnagram = true;
                } else {
                    isAnagram = false;
                    return isAnagram;

                }
            } else{
                isAnagram = false;
                return isAnagram;

            }

        }

        return isAnagram;

    }
}

