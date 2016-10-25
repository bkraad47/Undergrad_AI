

import java.util.*;


public class tictac {
       
   public static int player =1;                     
   public static int[][] fld;   


    public static int getPlayer() {
        return player;
    }


 
    public static void trn(int player) {
        Scanner sc=new Scanner(System.in);
        if (player == 1) {     
            print(fld);
           int eingabe;
           System.out.println("Choose box 1to9");
         eingabe = sc.nextInt();

            boolean check2 = true;
            for (int i = 0; i < 3; i++) {
              if (check2)
                    for (int j = 0; j < 3; j++) {
                        if (eingabe == 1) {
                          fld[i][j] = 1;
                            check2 = false;
                            break;
                      } else
                            eingabe--;
                  }
            }
        } else {               
            cordinate.maketrn(fld);
        }
    }



    public static boolean settrn(int x, int y) {
        if (fld[y][x] == 0) {
           fld[y][x] = player;
            return true;
       }
        return false;
    }
    public static void print(int fld[][]) {
        for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
                System.out.print(fld[i][j]);
              System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

               fld = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fld[i][j] = 0;
            }
        }
                while (0 == cordinate.won(fld)) {
           trn(player);
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
        if (cordinate.won(fld) == 1) {
            print(fld);
            System.out.println("player won!!!!!!");
        } else if (cordinate.won(fld) == 2) {
            print(fld);
            System.out.println("computer won!!!!!!");
        } else {
            print(fld);
            System.out.println("draw!!!!");
        }

    }
}