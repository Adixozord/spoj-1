#include <stdio.h>
#include <math.h>
int josephus(int n,int k){
    int l2=(int) floor(log2(n));
    return 2*(n - pow(2,l2)) +1;
}
int main(){
    int n,x,y,z;char e;
    while(scanf("%1d%1d%c%1d",&x,&y,&e,&z) && x|y|z!=0){
        n=(10*x+y)*((int) pow(10,z));
        printf("%d\n",josephus(n,2));
    }
    return 0;
}