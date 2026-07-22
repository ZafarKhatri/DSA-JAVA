class Solution {
    static class Group {
        int start, length;
        Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    static class SparseTable {
        private final int[][] st;

        SparseTable(int[] nums) {
            int n = nums.length;
            int k = 32 - Integer.numberOfLeadingZeros(Math.max(n, 1));
            st = new int[k + 1][n];
            if (n > 0) System.arraycopy(nums, 0, st[0], 0, n);
            for (int i = 1; i <= k; i++) {
                int len = 1 << i, half = 1 << (i - 1);
                for (int j = 0; j + len <= n; j++) {
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + half]);
                }
            }
        }

        int query(int l, int r) {
            int len = r - l + 1;
            int i = 31 - Integer.numberOfLeadingZeros(len);
            return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') ones++;

        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new Group(i, 1));
                }
            }
            zeroGroupIndex[i] = zeroGroups.size() - 1;
        }

        List<Integer> ans = new ArrayList<>();

        if (zeroGroups.isEmpty()) {
            for (int qi = 0; qi < queries.length; qi++) ans.add(ones);
            return ans;
        }

        int m = zeroGroups.size();
        int[] mergeLen = new int[Math.max(m - 1, 1)];
        for (int i = 0; i < m - 1; i++) {
            mergeLen[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
        }
        SparseTable st = (m > 1) ? new SparseTable(mergeLen) : null;

        for (int[] query : queries) {
            int l = query[0], r = query[1];

            int lIdx = zeroGroupIndex[l];
            int rIdx = zeroGroupIndex[r];

            int left = (lIdx == -1) ? -1
                    : zeroGroups.get(lIdx).length - (l - zeroGroups.get(lIdx).start);
            int right = (rIdx == -1) ? -1
                    : r - zeroGroups.get(rIdx).start + 1;

            int endGroupForAdjacent = (s.charAt(r) == '1') ? rIdx : rIdx - 1;
            int startAdj = lIdx + 1;
            int endAdj = endGroupForAdjacent - 1;

            int activeSections = ones;

            if (s.charAt(l) == '0' && s.charAt(r) == '0' && lIdx + 1 == rIdx) {
                activeSections = Math.max(activeSections, ones + left + right);
            } else if (startAdj <= endAdj && st != null) {
                activeSections = Math.max(activeSections, ones + st.query(startAdj, endAdj));
            }

            if (s.charAt(l) == '0' && lIdx + 1 <= endGroupForAdjacent) {
                activeSections = Math.max(activeSections,
                        ones + left + zeroGroups.get(lIdx + 1).length);
            }

            if (s.charAt(r) == '0' && lIdx < rIdx - 1) {
                activeSections = Math.max(activeSections,
                        ones + right + zeroGroups.get(rIdx - 1).length);
            }

            ans.add(activeSections);
        }

        return ans;
    }
}