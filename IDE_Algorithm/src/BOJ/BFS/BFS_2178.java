package BOJ.BFS;

import java.util.*;

public class BFS_2178 {

    private static Scanner scanner = new Scanner(System.in);
    private static int x = scanner.nextInt();
    private static int y = scanner.nextInt();
    private static int [][] board = new int [x][y];
    private final static int [] moveX = {1, 0, -1, 0};
    private final static int [] moveY = {0, 1, 0, -1};

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        for(int i = 0; i < x; i++) {
            String text = scanner.next();
            for(int j = 0; j < y; j++) {
                if(text.charAt(j) == '0') board[i][j] = -1;
                else board[i][j] = 0;
            }
        }
        scanner.close();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int startX = pair.x;
            int startY = pair.y;
            for(int i = 0; i < 4; i++) {
                int nowX = startX + moveX[i];
                int nowY = startY + moveY[i];

                if(nowX < 0 || nowX >= board.length ||
                        nowY < 0 || nowY >= board[0].length ||
                        board[nowX][nowY] == -1) continue;
                else if(board[nowX][nowY] > board[startX][startY] + 1 ||
                        board[nowX][nowY] == 0) {
                    board[nowX][nowY] = board[startX][startY] + 1;
                    queue.add(new Pair(nowX, nowY));
                }
            }
        }

        System.out.println(board[board.length-1][board[0].length-1] + 1);


    }

    static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
