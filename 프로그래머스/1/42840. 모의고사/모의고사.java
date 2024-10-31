import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] answer = {};

        List<List<Integer>> persons = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(2, 1, 2, 3, 2, 4, 2, 5),
                List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        );

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            for (int j = 1; j <= 3; j++) {
                List<Integer> person = persons.get(j - 1);
                if(answers[i] == person.get(i % person.size())) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }

        if(map.isEmpty()) {
            return answer;
        }

        int max = map.values()
                .stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getMax();

        answer = map.entrySet().stream()
                .filter(i -> i.getValue() == max)
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return answer;
    }
}