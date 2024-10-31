class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = {};

        int sum = (brown + 4) / 2;

        for(int i = 3; i <= sum-i; i++) {
            if((i -2) * (sum-i-2) == yellow) {
                return new int[]{sum-i, i};
            }
        }

        return answer;
    }
    
}