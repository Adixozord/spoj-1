#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(){
  int digits=25000;
  int *a;
  int i,b,c,d,e,f,g,r,p;
  d=0;
  f=10000;
  c=(digits/4 + 1)*14;
  a=(int *)malloc(sizeof(int)*c);
  for(i=0;i<c;i++){a[i]=20000000;}

  p=1;
  while(c>0){
      c-=14;
      if(c<=0) break;
      b=c;
      e=d%f;
      d=e;
      while(b>0){
          b--;
          if(b<=0) break;
          d=d*b+a[b];
          g=2*b-1;
          a[b]=(d%g)*f;
          d/=g;
      }
      r=e + d/f;
      if(r<1000){
          printf("%s",(r>99?"0":r>9?"00":"000"));
      }
      if(p){
        printf("%d.%d",r/1000,r%1000);
        p=0;
      }else{
        printf("%d",r);
      }
  }
  return 0;
}