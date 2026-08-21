// create map
// iterate through string array
// for every word sort that word
// use the sorted word as a key to check if there are other anagrams in the list
// if the next index is another anagram that matches the key, store it in that list
// if the next index isnt an anagram create a new list for that word
// index through the entire array of strings till they are all mapped anagram or not
// then take all of the contents of the map and put them into an array
// print the array with their sublists of anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create map
        Map<String, List<String>> map = new HashMap<>();

        // index through string array
        for (String str : strs) {
            // sort each word and assign them as the key
            String key = sortedStr(str);

            // if the map contains the sorted word store the word in the map
            if (map.containsKey(key)) {
                map.get(key).add(str);

                // if the map doesnt contain the sorted word, create a new
                // list with the unique word and put it in the map
            } else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        // return a new list with the sublists as each index
        return new ArrayList<>(map.values());
    }

    // pass in each index for this function
    private String sortedStr(String str) {
        // we create a map so that we can store the count
        // of each character for all 26 letters in the alphabet
        // we also make a new array so we can store the char cound
        // as a list to be then put into the map
        int[] map = new int[26];
        char[] arr = str.toCharArray();

        for (char curChar : arr) {
            map[curChar - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : map) {
            sb.append(num);
            sb.append("#");
        }

        return sb.toString();
    }
}
