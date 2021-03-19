package BOJ.BFS;

import java.util.*;

public class BFS_1697 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int count = 0;
        int [] map = new int [100001];
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int tagger = scanner.nextInt();
        boolean trigger = true;
        map[start] = 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        if(start == tagger) {
            System.out.println(0);
            trigger = false;
        }

        while(trigger) {
            int now = queue.poll();
            for(int i = 0; i < 3; i++) {
                int afterOp = now;
                if(i == 0) afterOp += 1;
                else if(i == 1) afterOp -= 1;
                else afterOp *= 2;

                if(afterOp == tagger) {
                    System.out.println(map[now]);
                    trigger = false;
                    break;
                }
                else if(afterOp < 0 || afterOp >= map.length || map[afterOp] != 0) continue;

                queue.add(afterOp);
                map[afterOp] = map[now]+1;
            }
        }
    }

}
