class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen)
            return ans;

        HashMap<String, Integer> need = new HashMap<>();

        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!need.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > need.get(word)) {

                    String remove = s.substring(left, left + wordLen);

                    seen.put(remove, seen.get(remove) - 1);

                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    ans.add(left);

                    String remove = s.substring(left, left + wordLen);
                    seen.put(remove, seen.get(remove) - 1);

                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
}
