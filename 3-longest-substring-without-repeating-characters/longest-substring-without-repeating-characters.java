class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;

        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));

            max = Math.max(max,r-l+1);
            r++;
        }


        // for (int i = 0; i < s.length(); i++) {
        //     // String temp = "";
        //     for (int j = i; j < s.length(); j++) {
        //         char c = s.charAt(j);
        //         // if (temp.indexOf(c) != -1) {
        //             // break;
        //         // }
        //         // temp += c;/
        //         max = Math.max(max, temp.length());
        //     }
        // }
        return max;
    }
}