#include<stdlib.h>
#include<limits.h>
#include<stdio.h>
int main(){
    char *m[13];
    m[1]="January";m[2]="February";m[3]="March";m[4]="April";
    m[5]="May";m[6]="June";m[7]="July";m[8]="August";
    m[9]="September";m[10]="October";m[11]="November";m[12]="December";
    int n,d;
    scanf("%d",&n);
    while(n--){scanf("%d",&d);printf("%d %s %d\n",d&31,m[(d&480)>>5],(d&8388096)>>9);}
    return 0;
}