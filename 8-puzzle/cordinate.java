public class cordinate{
    cordinate right=null;
    boolean expand=false;
     int[][] tab=new int[3][3];
     int cost=0;
  cordinate(int[][] tab1,int x){
  cost=x;
  for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
   tab[i][j]=tab1[i][j];
    }
  }
  }
  void print(){
      for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
  System.out.print(" "+tab[i][j]);
  }
      System.out.println("");
      }
      System.out.println("");
      System.out.println("cost:- "+cost);
            System.out.println("");
}
}