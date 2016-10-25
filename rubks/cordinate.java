public class cordinate{
    cordinate right=null;
    boolean expand=false;
     int[] tab1=new int[9];
          int[] tab2=new int[9];
               int[] tab3=new int[9];
                    int[] tab4=new int[9];
                         int[] tab5=new int[9];
                              int[] tab6=new int[9];
     int cost=0;
  cordinate(int[] tabx1,int[] tabx2,int[] tabx3,int[] tabx4,int[] tabx5,int[] tabx6,int x){
  cost=x;
  for(int i=0;i<9;i++){
   tab1[i]=tabx1[i];
    }
    for(int i=0;i<9;i++){
   tab2[i]=tabx2[i];
    }
      for(int i=0;i<9;i++){
   tab3[i]=tabx3[i];
    }
        for(int i=0;i<9;i++){
   tab3[i]=tabx3[i];
    }
          for(int i=0;i<9;i++){
   tab4[i]=tabx4[i];
    }
            for(int i=0;i<9;i++){
   tab5[i]=tabx5[i];
    }
              for(int i=0;i<9;i++){
   tab6[i]=tabx6[i];
    }
  }
  void print(){
          System.out.println("one");
      for(int i=0;i<9;i++){
  System.out.print(" "+tab1[i]);
    if((i+1)%3==0){
     System.out.println("");
  }
  }
      System.out.println("");
                System.out.println("two");
      for(int i=0;i<9;i++){
  System.out.print(" "+tab2[i]);
    if((i+1)%3==0){
     System.out.println("");
  }
  }
      System.out.println("");
                System.out.println("three");
      for(int i=0;i<9;i++){
  System.out.print(" "+tab3[i]);
    if((i+1)%3==0){
     System.out.println("");
  }
  }
      System.out.println("");
                System.out.println("four");
      for(int i=0;i<9;i++){
  System.out.print(" "+tab4[i]);
    if((i+1)%3==0){
     System.out.println("");
  }
  }
      System.out.println("");
                System.out.println("five");
      for(int i=0;i<9;i++){
  System.out.print(" "+tab5[i]);
    if((i+1)%3==0){
     System.out.println("");
  }
  }
      System.out.println("");
                System.out.println("six");
      for(int i=0;i<9;i++){
  System.out.print(" "+tab6[i]);
  if((i+1)%3==0){
     System.out.println("");
  }
  }
      System.out.println("");
      System.out.println("cost:- "+cost);
            System.out.println("");
}
}