import java.util.*;

public class puzzle{
  static int[][] tab=new int[3][3];
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
   static void print(int[][] g){
      for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
  System.out.print(" "+g[i][j]);
  }
      System.out.println("");
      }
      System.out.println("");
      System.out.println("");
}
    static cordinate pop(){
   cordinate tmp=tos;
   tos=tos.right;
   tmp.right=null;
   return tmp;
  }
    static int dx(int[][] a){
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
  static int h(int x,int y,int num){
    int px=0;
    int py=0;
    for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
      if(num==tab[i][j]){
      px=i;
      py=j;
      }
    }
    }
    int a=0;
    if(px>x){
    a=a+(px-x);
    }else{
      a=a+(x-px);
    }
    if(py>y){
          a=a+(py-y);
    }else{
      a=a+(y-py);
    }
    return a;
  }
  static int th(int[][] x){
  int cost=0;
      for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
    cost=cost+h(i,j,x[i][j]);
    }
    }
      return cost;
  }
  public static void main (String args[]){
 demo();
   Scanner sc=new Scanner(System.in);
 int[][] act=new int[3][3];
 act[0][0]=4;
 act[0][1]=1;
 act[0][2]=3;
 act[1][0]=7;
  act[1][1]=2;
   act[1][2]=6;
    act[2][0]=0;
     act[2][1]=5;
      act[2][2]=8;
      print(act);
      int p=0;
      System.out.println("type 1 for new puzzle or 0 to run default as shown(Note:-new puzzles heuristic cost sould be ver very very high)");
      p=sc.nextInt();
      if(p==1){
       act=new int[3][3];
  print(act);
 act[0][0]=sc.nextInt();
  print(act);
 act[0][1]=sc.nextInt();
  print(act);
 act[0][2]=sc.nextInt();
  print(act);
 act[1][0]=sc.nextInt();
  print(act);
  act[1][1]=sc.nextInt();
   print(act);
   act[1][2]=sc.nextInt();
    print(act);
    act[2][0]=sc.nextInt();
     print(act);
     act[2][1]=sc.nextInt();
      print(act);
      act[2][2]=sc.nextInt();
      print(act);
      }
      int ccost=0;
      int cx=dx(act);
      int cy=dy(act);
     cordinate gg=new cordinate(act,ccost+th(act));
     push(gg);
     tos.expand=true;
       tos.print();
     
       while(th(act)!=0){
         if(cx==2){
  
            int a=act[cx][cy];
         act[cx][cy]=act[cx-1][cy];
         act[cx-1][cy]=a;
         ccost++;
      cordinate c=new cordinate(act,ccost+th(act));
     push(c);
          a=act[cx][cy];
         act[cx][cy]=act[cx-1][cy];
         act[cx-1][cy]=a;
         ccost--;

         }
         if(cy==2){
         int a=act[cx][cy];
         act[cx][cy]=act[cx][cy-1];
         act[cx][cy-1]=a;
         ccost++;
      cordinate c=new cordinate(act,ccost+th(act));
     push(c);
      a=act[cx][cy];
         act[cx][cy]=act[cx][cy-1];
         act[cx][cy-1]=a;
         ccost--;
         }
         if(cx==1){
         int a=act[cx][cy];
           act[cx][cy]=act[cx-1][cy];
         act[cx-1][cy]=a;
         ccost++;
      cordinate c=new cordinate(act,ccost+th(act));
     push(c);
               a=act[cx][cy];
           act[cx][cy]=act[cx-1][cy];
         act[cx-1][cy]=a;
         ccost--;
   
                  a=act[cx][cy];
           act[cx][cy]=act[cx+1][cy];
         act[cx+1][cy]=a;
         ccost++;
               c=new cordinate(act,ccost+th(act));
     push(c);
 
              ccost--;
                  a=act[cx][cy];
           act[cx][cy]=act[cx+1][cy];
         act[cx+1][cy]=a;
         }
         if(cx==0){
      
                          int a=act[cx][cy];
           act[cx][cy]=act[cx+1][cy];
         act[cx+1][cy]=a;
         ccost++;
               cordinate c=new cordinate(act,ccost+th(act));
     push(c);

              ccost--;
                  a=act[cx][cy];
           act[cx][cy]=act[cx+1][cy];
         act[cx+1][cy]=a;
         }
         if(cy==1){
        
                  int a=act[cx][cy];
           act[cx][cy]=act[cx][cy-1];
         act[cx][cy-1]=a;
         ccost++;
      cordinate c=new cordinate(act,ccost+th(act));
     push(c);
   
               a=act[cx][cy];
           act[cx][cy]=act[cx][cy-1];
         act[cx][cy-1]=a;
         ccost--;
     
                  a=act[cx][cy];
           act[cx][cy]=act[cx][cy+1];
         act[cx][cy+1]=a;
         ccost++;
               c=new cordinate(act,ccost+th(act));
     push(c);
 
              ccost--;
                  a=act[cx][cy];
           act[cx][cy]=act[cx][cy+1];
         act[cx][cy+1]=a;
        }
         if(cy==0){
 
                        int a=act[cx][cy];
           act[cx][cy]=act[cx][cy+1];
         act[cx][cy+1]=a;
         ccost++;
               cordinate c=new cordinate(act,ccost+th(act));
     push(c);
    
              ccost--;
                  a=act[cx][cy];
           act[cx][cy]=act[cx][cy+1];
         act[cx][cy+1]=a;
         }
         System.out.println("Outpupt:-");
         cordinate x=min();
         act=x.tab;
           ccost=x.cost;
           x.expand=true;
           x.print();
           cx=dx(act);
           cy=dy(act);
       }
  }
}