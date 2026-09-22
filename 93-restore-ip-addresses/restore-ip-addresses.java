class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        backtrack(s, 0, 0, "", result);

        return result;
    }

    private void backtrack(
        String s,
        int index,
        int parts,
        String current,
        List<String> result
    ) {

        // 4 parts ban gaye
        if (parts == 4) {

            // Agar saare digits use ho gaye
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }

            return;
        }

        // Ek part mein maximum 3 digits
        for (int i = index; i < Math.min(index + 3, s.length()); i++) {

            String part = s.substring(index, i + 1);

            // Leading zero
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // 0 - 255
            int value = Integer.parseInt(part);

            if (value > 255) {
                break;
            }

            backtrack(
                s,
                i + 1,
                parts + 1,
                current + part + ".",
                result
            );
        }
    }
}