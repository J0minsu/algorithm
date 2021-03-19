package BOJ.BFS;

import java.util.*;

public class BFS_7576 {

    static Scanner scanner =  new Scanner(System.in);

    static int y = scanner.nextInt();
    static int x = scanner.nextInt();

    static final int [] moveX = {1, 0, -1, 0};
    static final int [] moveY = {0, 1, 0, -1};
    static int [][] box = new int [x][y];
    static int target = 0;
    static int time = -1;
    static Queue<Tomato> tomatoes = new LinkedList<>();
    static Queue<Tomato> nextTimeState;

    public static void main(String[] args) {

        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++) {
                box[i][j] = scanner.nextInt();
                if(box[i][j] == 0) target++;
                else if(box[i][j] == 1) tomatoes.add(new Tomato(i, j));
            }

        scanner.close();

        while(!tomatoes.isEmpty()) {

            Tomato tomato = tomatoes.poll();
            int startX = tomato.x;
            int startY = tomato.y;

            for(int i = 0; i < 4; i++) {
                int nowX = startX + moveX[i];
                int nowY = startY + moveY[i];

                if(nowX < 0 || nowX >= box.length ||
                        nowY < 0 || nowY >= box[0].length) continue;
                if(!(box[nowX][nowY] == 0)) continue;

                target--;
                tomatoes.add(new Tomato(nowX, nowY));
                box[nowX][nowY] = box[startX][startY] + 1;
            }
        }

        if(target != 0) System.out.println(-1);

        else {
            for(int i = 0; i < box.length; i++)
                for(int j = 0; j < box[0].length; j++)
                    time = time < box[i][j] ? box[i][j] : time;
            System.out.println(time-1);
        }

    }

    static class Tomato {
        private int x;
        private int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
