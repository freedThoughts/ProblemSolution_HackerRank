package implementation;

import java.util.Scanner;

public class CatsAndAMouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            
            int AC = Math.abs(x-z);
            int BC = Math.abs(y-z);
            if(AC == BC) System.out.println("Mouse C");
            else if( AC < BC) System.out.println("Cat A");
            else if(AC > BC) System.out.println("Cat B");
        }

    }
}
