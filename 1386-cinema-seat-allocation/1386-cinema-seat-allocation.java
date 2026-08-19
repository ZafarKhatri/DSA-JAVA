import java.util.*;

class Solution { 
    public int maxNumberOfFamilies(int n, int[][] rs) { 
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        for(int[] r: rs) { 
            int row = r[0], seat = r[1]; 
            mp.merge(row, 1 << (10 - seat), (a, b) -> a | b); 
        } 
        int ans = (n - mp.size()) * 2; 
        int[] masks = {0b0111100000, 0b0000011110, 0b0001111000}; 
        for(int x: mp.values()) { 
            for(int m: masks) { 
                if((m & x) == 0) { 
                    ans++; 
                    x |= m; 
                } 
            } 
        } 
        return ans; 
    } 

    public int maxNumberOfFamiliesUsingList(int n, int[][] rs) { 
        HashMap<Integer, List<Integer>> mp = new HashMap<>(); 
        for(int[] r: rs) { 
            if(r[1] == 1 || r[1] == 10) continue; 
            mp.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]); 
        } 
        int sz = mp.size(); 
        int left = n - sz; 
        int ans = 2 * left; 
        for(Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) { 
            List<Integer> value = entry.getValue(); 
            boolean block1 = true, block2 = true, block3 = true; 
            for(Integer x: value) { 
                if(x >= 2 && x <= 5) block1 = false; 
                if(x >= 4 && x <= 7) block2 = false; 
                if(x >= 6 && x <= 9) block3 = false; 
            } 
            if(block1 && block3) ans += 2; 
            else if(block1 || block2 || block3) ans += 1; 
        }; 
        return ans; 
    } 
}
