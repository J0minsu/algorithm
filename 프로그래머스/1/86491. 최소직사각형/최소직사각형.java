class Solution {
    public int solution(int[][] sizes) {
        
        int bigMax = 0;
        int smallMax = 0;

        for (int[] arr : sizes) {
            int big;
            int small;
            if(arr[0] > arr[1]) {
                big = arr[0];
                small = arr[1];
            }
            else {
                big = arr[1];
                small = arr[0];
            }

            bigMax = Math.max(bigMax, big);
            smallMax = Math.max(smallMax, small);
        }

        return bigMax * smallMax;
    }
    
}