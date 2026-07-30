class Solution {

    public String reverseWords(String s) {

        // remove leading/trailing spaces
        // split on one or more spaces
        String[] str = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // traverse from back to front
        for (int i = str.length - 1; i >= 0; i--) {

            result.append(str[i]);

            // avoid trailing space
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}