class Solution {

    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> parents = new HashMap<>();

    public List<List<String>> findLadders(
            String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return result;
        }

        Set<String> current = new HashSet<>();
        current.add(beginWord);

        boolean found = false;

        while (!current.isEmpty() && !found) {

            dict.removeAll(current);

            Set<String> next = new HashSet<>();

            for (String word : current) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) continue;

                        arr[i] = c;
                        String newWord = new String(arr);

                        if (dict.contains(newWord)) {

                            next.add(newWord);

                            parents.computeIfAbsent(
                                newWord, k -> new ArrayList<>()
                            ).add(word);

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            current = next;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, path);
        }

        return result;
    }

    private void dfs(String word, String beginWord,
                     List<String> path) {

        if (word.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, path);

            path.remove(path.size() - 1);
        }
    }
}