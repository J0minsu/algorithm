package LINE;

import java.util.Scanner;

public class RECO_ID {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String id = scanner.next();

        id = id.toLowerCase();
        System.out.println("step 01 =" + id);

        id = id.replaceAll("[^-_.a-z0-9]", "");
        System.out.println("step 02 =" + id);

        id = id.replaceAll("[.]{2,}",".");
        System.out.println("step 03 =" + id);

        id = id.replaceAll("^[.]|[.]$", "");
        System.out.println("step 04 ="+ id);

        if(id.equals("")) id += "a";
        System.out.println("step 05 =" + id);

        if(id.length() >= 16) id = id.substring(0, 15);
        id = id.replaceAll("^[.]|[.]$", "");
        System.out.println("step 06 =" + id);

        if(id.length() <= 2)
            while(id.length() != 3)
                id += id.charAt(id.length()-1);

        System.out.println("step 07 =" + id);


    }
}
