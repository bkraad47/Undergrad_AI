import java.util.*;

public class puzzle{
  static int[] tab1=new int[9];
    static int[] tab2=new int[9];  
      static int[] tab3=new int[9];
        static int[] tab4=new int[9];
          static int[] tab5=new int[9];
        static int[] tab6=new int[9];
   static cordinate tos=null;
   static cordinate min=null;
   static cordinate minprev=null;
  static void push(cordinate c){
   
    if(tos==null){
      tos=c;
    }else{
    cordinate tmp=tos;
    tos=c;
    tos.right=tmp;
    }
  
  }
   static void print(int[] g){
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
   }
    static cordinate pop(){
   cordinate tmp=tos;
   tos=tos.right;
   tmp.right=null;
   return tmp;
  }
     static int[] clock(int[] a){
     int[] x=new int[9];
x[0]=a[6];
x[1]=a[3];
x[2]=a[0];
x[3]=a[7];
x[4]=a[4];
x[5]=a[1];
x[6]=a[8];
x[7]=a[5];
x[8]=a[2];
return x;
     }
          static int[] anticlock(int[] a){
     int[] x=new int[9];
x[8]=a[6];
x[7]=a[3];
x[6]=a[0];
x[5]=a[7];
x[4]=a[4];
x[3]=a[1];
x[2]=a[8];
x[1]=a[5];
x[0]=a[2];
return x;
     }
   /* static int dx(int[][] a){
      int tmp=0;
        for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
      if(a[i][j]==0){
      tmp=i;
      }
    }
        }
        return tmp;
    }
        static int dy(int[][] a){
      int tmp=0;
        for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
      if(a[i][j]==0){
      tmp=j;
      }
    }
        }
        return tmp;
    }
       */
    static cordinate min(){
    cordinate x=tos;
    if(x.expand==true)
      while(x.expand!=false && x.right!=null){
    x=x.right;
    }
    min=x;
    while(x!=null){
      if(min.cost>x.cost && x.expand==false){
      min=x;
      }
    x=x.right;
    }
    return min;
    }
  static void demo(){
   
  for(int i=0;i<9;i++){
   tab1[i]=1;
  }
    for(int i=0;i<9;i++){
   tab2[i]=2;
  }
      for(int i=0;i<9;i++){
   tab3[i]=3;
  }
        for(int i=0;i<9;i++){
   tab4[i]=4;
  }
          for(int i=0;i<9;i++){
   tab5[i]=5;
  }
            for(int i=0;i<9;i++){
   tab6[i]=6;
  }
  }
  static int h(int x,int y){
int a=0;
if(( x>1 && x <6)&&(y>1 && y<6)){
  if(x>y){
  a=x-y;
  }else{
  a=y-x;
  }
}else{
a=1;
}
   return a;
  }
  static int th(){
   int cost=0;
             for(int i=0;i<9;i++){
               if(tab1[i]!=1){
                 cost=cost+h(1,tab1[i]);
               }
  }
                          for(int i=0;i<9;i++){
               if(tab2[i]!=2){
                 cost=cost+h(2,tab2[i]);
               }
  }
                                       for(int i=0;i<9;i++){
               if(tab3[i]!=3){
                 cost=cost+h(3,tab3[i]);
               }
  }
                                                    for(int i=0;i<9;i++){
               if(tab4[i]!=4){
                 cost=cost+h(4,tab4[i]);
               }
  }
                                                                 for(int i=0;i<9;i++){
               if(tab5[i]!=5){
                 cost=cost+h(5,tab5[i]);
               }
  }
                                                                              for(int i=0;i<9;i++){
               if(tab6[i]!=6){
                 cost=cost+h(6,tab6[i]);
               }
  }
    
      return cost;
  }
  public static void main (String args[]){
 demo();
tab1[2]=5;
tab1[5]=5;
tab1[8]=5;
  tab3[2]=1;
tab3[5]=1;
tab3[8]=1;
  tab6[2]=3;
tab6[5]=3;
tab6[8]=3;
  tab5[2]=6;
tab5[5]=6;
tab5[8]=6;
tab4=anticlock(tab4);
      int ccost=0;
     cordinate gg=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
     push(gg);
     tos.expand=true;
       tos.print();
       cordinate x=gg;
       while(th()!=0){
        int a=0;
        int b=0;
        int c=0;
        a=tab1[2];
b=tab1[5];
c=tab1[8];
 tab1[2]=tab3[2];
tab1[5]=tab3[5];
tab1[8]=tab3[8];
  tab3[2]=tab6[2];
tab3[5]=tab6[5];
tab3[8]=tab6[8];
  tab6[2]=tab5[2];
tab6[5]=tab5[5];
tab6[8]=tab5[8];
  tab5[2]=a;
tab5[5]=b;
tab5[8]=c;
tab4=clock(tab4);
ccost++;
  cordinate tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
       a=tab1[2];
b=tab1[5];
c=tab1[8];
 tab1[2]=tab5[2];
tab1[5]=tab5[5];
tab1[8]=tab5[8];
  tab5[2]=tab6[2];
tab5[5]=tab6[5];
tab5[8]=tab6[8];
  tab6[2]=tab3[2];
tab6[5]=tab3[5];
tab6[8]=tab3[8];
  tab3[2]=a;
tab3[5]=b;
tab3[8]=c;
tab4=anticlock(tab4);
ccost++;
 tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
   ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
a=tab2[2];
b=tab2[5];
c=tab2[8];
 tab2[2]=tab1[8];
tab2[5]=tab1[7];
tab2[8]=tab1[6];
  tab1[6]=tab4[0];
tab1[7]=tab4[3];
tab1[8]=tab4[6];
  tab4[0]=tab6[2];
tab4[3]=tab6[1];
tab4[6]=tab6[0];
  tab6[0]=a;
tab6[1]=b;
tab6[2]=c;
tab3=anticlock(tab3);
ccost++;
tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
       a=tab6[0];
b=tab6[1];
c=tab6[2];
 tab6[0]=tab4[6];
tab6[1]=tab4[3];
tab6[2]=tab4[0];
  tab4[0]=tab1[6];
tab4[3]=tab1[7];
tab4[6]=tab1[8];
  tab1[6]=tab2[8];
tab1[7]=tab2[5];
tab1[8]=tab2[2];
  tab2[2]=a;
tab2[5]=b;
tab2[8]=c;
tab3=clock(tab3);
ccost++;
 tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
   ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
       
       
       //left
        a=tab1[0];
b=tab1[3];
c=tab1[6];
 tab1[0]=tab3[0];
tab1[3]=tab3[3];
tab1[6]=tab3[6];
  tab3[0]=tab6[0];
tab3[3]=tab6[3];
tab3[6]=tab6[6];
  tab6[0]=tab5[0];
tab6[3]=tab5[3];
tab6[6]=tab5[6];
  tab5[0]=a;
tab5[3]=b;
tab5[6]=c;
tab2=clock(tab2);
ccost++;
 tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
   ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
       a=tab1[0];
b=tab1[3];
c=tab1[6];
 tab1[0]=tab5[0];
tab1[3]=tab5[3];
tab1[6]=tab5[6];
  tab5[0]=tab6[0];
tab5[3]=tab6[3];
tab5[6]=tab6[6];
  tab6[0]=tab3[0];
tab6[3]=tab3[3];
tab6[6]=tab3[6];
  tab3[0]=a;
tab3[3]=b;
tab3[6]=c;
tab2=anticlock(tab2);
ccost++;
tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
a=tab2[0];
b=tab2[3];
c=tab2[6];
 tab2[0]=tab6[6];
tab2[3]=tab6[7];
tab2[6]=tab6[8];
  tab6[6]=tab4[8];
tab6[7]=tab4[5];
tab6[8]=tab4[2];
  tab4[8]=tab1[2];
tab4[5]=tab1[1];
tab4[2]=tab1[0];
  tab1[2]=a;
tab1[1]=b;
tab1[0]=c;
tab5=anticlock(tab5);
ccost++;
tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
       a=tab2[0];
b=tab2[3];
c=tab2[6];
 tab2[0]=tab1[2];
tab2[3]=tab1[1];
tab2[6]=tab1[0];
  tab1[2]=tab4[8];
tab1[1]=tab4[5];
tab1[0]=tab4[2];
  tab4[8]=tab6[6];
tab4[5]=tab6[7];
tab4[2]=tab6[8];
  tab6[6]=a;
tab6[7]=b;
tab6[8]=c;
tab5=clock(tab5);
ccost++;
tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
       //top
        a=tab2[0];
b=tab2[1];
c=tab2[2];
 tab2[0]=tab3[0];
tab2[1]=tab3[1];
tab2[2]=tab3[2];
  tab3[0]=tab4[0];
tab3[1]=tab4[1];
tab3[2]=tab4[2];
  tab4[0]=tab5[0];
tab4[1]=tab5[1];
tab4[2]=tab5[2];
  tab5[0]=a;
tab5[1]=b;
tab5[2]=c;
tab1=clock(tab1);
ccost++;
tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;     
              a=tab2[0];
b=tab2[1];
c=tab2[2];
 tab2[0]=tab5[0];
tab2[1]=tab5[1];
tab2[2]=tab5[2];
  tab5[0]=tab4[0];
tab5[1]=tab4[1];
tab5[2]=tab4[2];
  tab4[0]=tab3[0];
tab4[1]=tab3[1];
tab4[2]=tab3[2];
  tab3[0]=a;
tab3[1]=b;
tab3[2]=c;
tab1=anticlock(tab1);
ccost++;
tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
  ccost--;
     push(tmp);
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;      
       
       //bottom
       
       a=tab2[6];
       b=tab2[7];
       c=tab2[8];
       tab2[6]=tab3[6];
       tab2[7]=tab3[7];
       tab2[8]=tab3[8];
       tab3[6]=tab4[6];
       tab3[7]=tab4[7];
       tab3[8]=tab4[8];
       tab4[6]=tab5[6];
       tab4[7]=tab5[7];
       tab4[8]=tab5[8];
       tab5[6]=a;
       tab5[7]=b;
       tab5[8]=c;
       tab6=anticlock(tab6);
       ccost++;
       tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
       ccost--;
       push(tmp);
       tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;   
       
       a=tab2[6];
       b=tab2[7];
       c=tab2[8];
       tab2[6]=tab5[6];
       tab2[7]=tab5[7];
       tab2[8]=tab5[8];
       tab5[6]=tab4[6];
       tab5[7]=tab4[7];
       tab5[8]=tab4[8];
       tab4[6]=tab3[6];
       tab4[7]=tab3[7];
       tab4[8]=tab3[8];
       tab3[6]=a;
       tab3[7]=b;
       tab3[8]=c;
       tab6=clock(tab6);
       ccost++;
       tmp=new cordinate(tab1,tab2,tab3,tab4,tab5,tab6,ccost+th());
       ccost--;
       push(tmp);
       tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;     
         System.out.println("Output:-");
        x=min();
     tab1=x.tab1;
       tab2=x.tab2;
       tab3=x.tab3;
       tab4=x.tab4;
       tab5=x.tab5;
       tab6=x.tab6;
           ccost=x.cost;
           x.expand=true;
           x.print();

       }
  }
}