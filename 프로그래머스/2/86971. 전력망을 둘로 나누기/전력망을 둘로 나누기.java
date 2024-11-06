import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] wire : wires) {
            map.putIfAbsent(wire[0], new ArrayList<>());
            map.putIfAbsent(wire[1], new ArrayList<>());
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            map.get(from).remove((Integer) to);
            map.get(to).remove((Integer) from);

            // DFS로 노드 수 계산
            int count = dfs(from, map, new HashSet<>());
            int otherCount = n - count;

            // 차이 계산
            answer = Math.min(answer, Math.abs(count - otherCount));

            // 전선 복구
            map.get(from).add(to);
            map.get(to).add(from);

        }

        return answer;
    }
    
    public int dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        visited.add(node);
        int count = 1; // 현재 노드 카운트

        for (int neighbor : map.get(node)) {
            if (!visited.contains(neighbor)) {
                count += dfs(neighbor, map, visited);
            }
        }

        return count;
    }
}