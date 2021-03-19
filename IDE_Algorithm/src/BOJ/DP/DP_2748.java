package BOJ.DP;

import java.util.Scanner;

public class DP_2748 {

    public static void main(String [] arge) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long after;
        long first = 0;
        if(count == 0)
            after  = 0;
        else
            after = 1;

        int ope = 1;
        while(ope != count && count != 0) {
            long buf = after;
            after = first + buf;
            first = buf;
            ope++;
        }

        System.out.print(after);
    }
}
