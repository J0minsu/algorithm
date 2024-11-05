import java.util.ArrayList;
import java.util.*;

class Solution {
    
    int maxDungeons = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        backtrack(k, dungeons, visited, 0);
        return maxDungeons;
    }
    
    public void backtrack(int k, int[][] dungeons, boolean[] visited, int count) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 던전을 방문하지 않았고, 필요 체력이 충분한 경우
                visited[i] = true; // 던전 방문 표시
                backtrack(k - dungeons[i][1], dungeons, visited, count + 1); // 체력 소모 후 재귀 호출
                visited[i] = false; // 던전 방문 해제
            }
        }
    }
    
}



