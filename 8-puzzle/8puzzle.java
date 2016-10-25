public class puzzle{
  int[][] tab=new int[3][3];
  static void demo(){
    int x=1;
  for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
      if(x!=9){
      tab[i][j]=x;
    x++;
      }
    }
  }
  }
  public static void main (String args[]){
 demo();
  }
}