class Solution {
    public boolean isValid(String s) {
        /*
        Iterate through the list ot characters,
        use a stack and store the entire string.
        Iterate starting from behind the stack
        and check if the current index matches with
        the first element popped from the stack
        return true if they match return false if 
        it doesnt match
        */
        Stack<Character> result = new Stack<>();

        for(char c: s.toCharArray()){

            if (c == '('){
                result.push(')');
            } else if (c == '{'){
                result.push('}');
            } else if (c == '['){
                result.push(']');
            } else {
                if (result.isEmpty() || result.pop() != c){
                    return false;
                }
            }
        }

        return result.isEmpty();
    }
}
