#include<stdio.h>
int main(){
    char *m[13]={"","January","February","March","April","May","June","July","August","September","October","November","December"};
    int n,d;
    scanf("%d",&n);
    while(n--){scanf("%d",&d);printf("%d %s %d\n",d&31,m[(d&480)>>5],(d&8388096)>>9);}
    return 0;
}