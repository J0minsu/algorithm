import java.util.*;
import java.util.stream.IntStream;

class Solution {
    
    char[] charArray = {'A', 'E', 'I', 'O', 'U'};
    List<String> lists = new ArrayList<>();
    
    public int solution(String word) {
        bruteForceSearch(1, new StringBuilder(), word);

        for (int i = 0; i < lists.size(); i++) {
            if(word.equals(lists.get(i))) {
                return i + 1;
            }
        }
        
        return -1;
    }
    
    public void bruteForceSearch(int size, StringBuilder builder, String word) {

            //char roof
            IntStream.range(0, charArray.length).boxed().forEach(j -> {
                if(size <= 5) {
                    StringBuilder append = builder.append(charArray[j]);
                    lists.add(append.toString());
                    bruteForceSearch(size + 1, append, word);
                    append.deleteCharAt(append.length()-1);
                }

            });

    }
    
}