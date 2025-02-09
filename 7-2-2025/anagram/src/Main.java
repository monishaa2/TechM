import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLength = p.length();
        int sLength = s.length();

        if (sLength < pLength) return result;

        for (int i = 0; i <= sLength - pLength; i++) {
            String sub = s.substring(i, i + pLength);
            if (isAnagram(sub, p)) {
                result.add(i);
            }
        }

        return result;
    }


    private boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("abccabbbscab", "abc"));
    }
}
