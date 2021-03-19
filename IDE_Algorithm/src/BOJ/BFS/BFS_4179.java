package BOJ.BFS;

import java.util.*;

public class BFS_4179 {

    private static Scanner scanner = new Scanner(System.in);
    private static int x = scanner.nextInt();
    private static int y = scanner.nextInt();
    private static int [][] fireMap = new int [x][y];
    private static int [][] exitMap = new int [x][y];
    private static Queue<Pair> queue = new LinkedList<>();
    private static final int [] moveX = {1, 0, -1, 0};
    private static final int [] moveY = {0, 1, 0, -1};
    private static boolean isExit = false;
    private static int min = 99999;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Pair fireStart = null;
        Pair exitStart = null;
        fireMap = new int [x][y];
        exitMap = new int [x][y];
        for(int i = 0; i < x; i++) {
            String text = scanner.next();
            for(int j = 0; j < y; j++) {
                if(text.charAt(j) == '#') {
                    fireMap[i][j] = -1;
                    exitMap[i][j] = -1;
                }
                else if(text.charAt(j) == 'F') {
                    queue.add(new Pair(i, j));
                    fireMap[i][j] = 1;
                }
                else if(text.charAt(j) == 'J')
                    exitStart = new Pair(i, j);
            }
        }

        //fire increase check
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int startX = pair.x;
            int startY = pair.y;

            for(int i = 0; i < 4; i++) {
                int nowX = startX + moveX[i];
                int nowY = startY + moveY[i];

                if(nowX < 0 || nowX >= x || nowY < 0 || nowY >= y ||
                        fireMap[nowX][nowY] == -1) continue;
                if(fireMap[nowX][nowY] > 0) {
                    fireMap[nowX][nowY] = fireMap[nowX][nowY] > fireMap[startX][startY] + 1 ?
                            fireMap[startX][startY] + 1 : fireMap[nowX][nowY];
                    continue;
                }
                queue.add(new Pair(nowX, nowY));
                fireMap[nowX][nowY] = fireMap[startX][startY] + 1;
            }
        }

        //exit route
        queue.add(exitStart);
        exitMap[exitStart.x][exitStart.y] = 1;
        while(!queue.isEmpty() && !isExit) {
            Pair pair = queue.poll();
            int startX = pair.x;
            int startY = pair.y;

            for(int i = 0; i < 4; i++) {
                int nowX = startX + moveX[i];
                int nowY = startY + moveY[i];

                if(nowX < 0 || nowX >= x || nowY < 0 || nowY >= y) {
                    min = min > exitMap[startX][startY] ? exitMap[startX][startY] : min;
                    isExit = true;
                    break;
                }
                else if(exitMap[nowX][nowY] > 0 || exitMap[nowX][nowY] == -1) continue;

                if(exitMap[startX][startY] + 1 >= fireMap[nowX][nowY] && !(fireMap[nowX][nowY] == 0)) {
                    exitMap[nowX][nowY] = -1;
                    continue;
                }

                queue.add(new Pair(nowX, nowY));
                exitMap[nowX][nowY] = exitMap[startX][startY] + 1;

            }
        }
        if(!isExit) System.out.println(IMPOSSIBLE);
        else System.out.println(min);

    }

    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x, y = " + x + ", " + y;
        }
    }

}
