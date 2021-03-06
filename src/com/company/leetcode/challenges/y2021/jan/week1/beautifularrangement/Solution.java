package com.company.leetcode.challenges.y2021.jan.week1.beautifularrangement;

public class Solution {

    private static int count;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countArrangement(15));
    }

    public int countArrangement(int n) {
        count = 0;
        countArrangement(1, new boolean[n + 1]);
        return count;
    }

    private void countArrangement(int idx, boolean[] visited) {
        if (idx == visited.length) {
            count++;
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && allowed(idx, i)) {
                visited[i] = true;
                countArrangement(idx + 1, visited);
                visited[i] = false;
            }
        }
    }

    private boolean allowed(int index, int i) {
        return index % i == 0 || i % index == 0;
    }
}
