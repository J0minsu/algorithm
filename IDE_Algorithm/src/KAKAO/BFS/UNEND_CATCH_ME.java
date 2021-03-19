package KAKAO.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CATCH_ME {

    private static Queue<Integer> queue = new LinkedList<>();
    private static int [] catcherBoard = new int [200001];
    private static int [] runnerBoard = new int [200001];
    private static int count = 0;
    private static int lastRunnerIndex = 0;

    public static void main(String [] args) {


        BFS(2, 11);

    }

    private static void BFS(int catcher, int runner) {

        if (catcher == runner) {
            System.out.println(-1);
            return;
        }

        catcherBoard[catcher] = 1;
        runnerBoard[runner] = 1;
        lastRunnerIndex = runner;
        queue.add(catcher);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            if(lastRunnerIndex + count > 200000) {
                System.out.println(-1);
                return;
            }
            runnerBoard[lastRunnerIndex + count] = count;
            lastRunnerIndex += count;

            for (int i = 0; i <= 2; i++) {
                if (i == 0) now += 1;
                else if (i == 1) now -= 1;
                else now *= 2;

                if(lastRunnerIndex == now && runnerBoard[lastRunnerIndex + count] == count) {
                    System.out.println(count);
                    return;
                }

                //escape condition
                if(now < 0 || now > 200000) continue;
                else {
                    queue.add(now);
                    catcherBoard[now] = count;
                }
            }
        }
    }
}
