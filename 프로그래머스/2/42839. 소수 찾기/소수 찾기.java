import java.util.*;

class Solution {
    
    // 주어진 숫자들로 소수의 개수를 반환하는 메인 함수
    public int solution(String numbers) {

        Set<Integer> primeSet = new HashSet<>();
        char[] chars = numbers.toCharArray();
        boolean[] used = new boolean[chars.length]; // 사용 여부를 기록하는 배열

        generateNumbers(chars, used, new StringBuilder(), primeSet);

        return primeSet.size();
    }

    // 백트래킹을 통해 가능한 모든 숫자 조합 생성
    public void generateNumbers(char[] numbers, boolean[] used, StringBuilder current, Set<Integer> uniquePrimes) {
        if (current.length() != 0) {
            int num = Integer.parseInt(current.toString());
            if (isPrime(num)) {
                uniquePrimes.add(num);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) { // 사용되지 않은 숫자만 선택
                used[i] = true; // 현재 숫자 사용
                current.append(numbers[i]); // 현재 숫자 추가
                generateNumbers(numbers, used, current, uniquePrimes); // 재귀 호출
                current.deleteCharAt(current.length() - 1); // 마지막 숫자 제거
                used[i] = false; // 현재 숫자 미사용으로 되돌리기
            }
        }
    }

    // 소수 판별 함수
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
}