package BOJ.BFS;

import java.util.*;

public class BFS_1926 {

    static boolean [][] isVisit;
    static boolean [][] board;
    static int [] moveX = {1, 0, -1, 0};
    static int [] moveY = {0, 1, 0, -1};
    static int theBiggestBreadth = 0;
    static int rectNumber = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        board = new boolean[x][y];
        isVisit = new boolean [x][y];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(scanner.nextInt() == 1)
                    board[i][j] = true;
                else isVisit[i][j] = true;

            }
        }
        scanner.close();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(!isVisit[i][j]) {
                    rectNumber++;
                    isVisit[i][j] = true;
                    BFS(new Pair(i, j));
                }
            }
        }
        System.out.println(rectNumber);
        System.out.println(theBiggestBreadth);
    }

    //BFS - 목적지로 가는 방법
    static void BFS(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        int breadth = 1;
        while(!queue.isEmpty()) {
            Pair currentPair = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = currentPair.x + moveX[i];
                int ny = currentPair.y + moveY[i];

                if(nx < 0 || nx >= board.length ||
                        ny < 0 || ny >= board[0].length ||
                        isVisit[nx][ny] || !board[nx][ny]) continue;
                else {
                    isVisit[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                    breadth++;
                }
            }
        }

        theBiggestBreadth = theBiggestBreadth > breadth ? theBiggestBreadth : breadth;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}