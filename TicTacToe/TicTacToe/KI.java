
public class KI {

      public static int won(int[][] fld) {

        int hor;
         int ver;
        int dg1 = 0;
          int dg2 = 0;
          int empt = 9;
           int win = 0;

        for (int i = 0; i < 3; i++) {
            hor = 0;
            ver = 0;

            for (int j = 0; j < 3; j++) {
              if (fld[i][j] == 1){
                    hor++;
              } else if (fld[i][j] == 2){
                    hor--;
            }
              if (fld[j][i] == 1){
                    ver++;
              }else if (fld[j][i] == 2){
                    ver--;
              }
                    if (fld[i][j] != 0){
                    empt--;
                    }
            }
            if (fld[i][i] == 1){
                dg1++;
            }else if (fld[i][i] == 2){
                dg1--;
            }
            if (fld[2 - i][i] == 1){
                dg2++;
            }else if (fld[2 - i][i] == 2){
                dg2--;
              }
              if (hor == 3){
                return 1;
            } else if (hor == (0 - 3)){
                return 2;
            }
            if (ver == 3){
                return 1;
            } else if (ver == (0 - 3)){
                return 2;
            }
         }
        if (dg1 == 3){
            return 1;
        }else if (dg1 == (0 - 3)){
            return 2;
          }
           if (dg2 == 3){
              return 1;
        }else if (dg2 == (0 - 3)){
              return 2;
        }
        if (empt == 0){
            return 3;
        }
        return win;
    }
    public static void maketrn(int[][] fld) {
        int frees = 0;

   
              for (int i = 0; i < 3; i++) {
               for (int j = 0; j < 3; j++) {
                if (fld[i][j] == 0) {
                    frees++;
                }
            }
         }
int depth=9;
        int trn1[] = mim(fld, depth, TicTacToe.player, frees);
          TicTacToe.settrn(trn1[1], trn1[2]);
    }

 
      public static int[] mim(int[][] fld, int depth, int player, int frees) {
 
        int[][] tmp = new int[frees][3];
          int[] mm = new int[3];
        int[] tmpmm = new int[2];
   
        if (depth-- == 0 || frees == 0) {
               tmpmm[0] = asses(fld);
              mm[0] = tmpmm[0];
            return mm;
           } else if (2 == won(fld) || 1 == won(fld) || 3 == won(fld)) {
            tmpmm[0] = asses(fld);
              mm[0] = tmpmm[0];
            return mm;
             } else {
              if (player == 1) {
                 player = 2;
            } else {
                player = 1;
            }

            int in = 0;
              int[][][] nxt = new int[frees][3][3];

            for (int i = 0; i < frees; i++) {
                     for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                           nxt[i][x][y] = fld[x][y];
                    }
                  }
            }

                    while (in < frees) {
                   for (int x = 0; x < 3; x++) {
                     for (int y = 0; y < 3; y++) {
                             if (in < frees && nxt[in][x][y] == 0) {
                            if (player == 1) {
                                nxt[in][x][y] = 2;
                              } else {
                                   nxt[in][x][y] = 1;
                               }
                               tmp[in][2] = x;
                            tmp[in][1] = y;
                               tmpmm = mim(nxt[in], depth, player, (frees - 1));
                            tmp[in][0] = tmpmm[0];
                                in++;
                        }
                     }
                }
               }
            tmpmm[0] = 0;
   
              if (player == 1) {
                tmpmm[1] = tmp[0][0];
                     for (int i = tmpmm[0]; i < frees; i++) {
                    if (tmpmm[1] < tmp[i][0]) {
                           tmpmm[0] = i;
                          tmpmm[1] = tmp[i][0];
                     }
                }
               } else {
                tmpmm[1] = tmp[0][0];
                   for (int i = tmpmm[0]; i < frees; i++) {
                    if (tmpmm[1] > tmp[i][0]) {
                        tmpmm[0] = i;
                          tmpmm[1] = tmp[i][0];
                         }
                 }
             }
            return tmp[tmpmm[0]];
         }
     }

     public static int asses(int[][] nxt) {
         int min = 0;
         int max = 0;

         int[] chk = new int[8];
 
         int hor;
         int ver;
          int dg1 = 0;
          int dg2 = 0;
   
         for (int i = 0; i < 3; i++) {
  
              hor = 0;
            ver = 0;
 
             for (int j = 0; j < 3; j++) {
                  if (nxt[i][j] == 1) {
                    hor--;
                } else if (nxt[i][j] == 2) {
                       hor++;
                }
                if (nxt[j][i] == 1) {
                      ver--;
                } else if (nxt[j][i] == 2) {
                    ver++;
                }
            }

            if (nxt[i][i] == 1) {
                dg1--;
            } else if (nxt[i][i] == 2) {
                dg1++;
            }

            if (nxt[2 - i][i] == 1) {
                dg2--;
            } else if (nxt[2 - i][i] == 2) {
                dg2++;
            }

            chk[i] = hor;
            chk[3 + i] = ver;
        }

           chk[6] = dg1;
          chk[6 + 1] = dg2;

           for (int i = 0; i < chk.length; i++) {
            if (max < chk[i])
                max = chk[i];
            else if (min > chk[i])
                min = chk[i];
        }
        return min + max;
    }
}
