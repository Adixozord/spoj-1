#include <stdio.h>
#include <stdlib.h>

#define MIN(a,b) (a > b)? b : a

int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

int pour(int ja,int jb,int c){
    int a=ja;
    int moves=1; //llenar "A" cuenta como movimiento
    int b=0;
    int transfer=0;
    while(a!=c && b!=c){
        if(a==0){
            a=ja;moves++;
        }
        transfer=MIN(a,jb-b);
        a-=transfer;
        b+=transfer;
        moves++;
        if(a==c || b==c){break;}
        if(b==jb){
            b=0;moves++;
        }
    }
    return moves;
}

int main(){
    int n,i,a,b,c,t,fromA,fromB,*moves;
    scanf("%d",&t);
    n=t;
    i=0;
    moves=(int *)malloc(sizeof(int)*t);
    while(t--){
        scanf("%d%d%d",&a,&b,&c);
        if(c>a && c>b){
            moves[i++]=-1;
        }else if(c % gcd(a,b)!=0){
            moves[i++]=-1;
        }else if(c==a || c==b){
            moves[i++]=1;
        }else{
            fromA=pour(a,b,c);
            fromB=pour(b,a,c);
            moves[i++]=MIN(fromA,fromB);
        }
    }
    for(i=0;i<n;i++){
        printf("%d\n",moves[i]);
    }
    return 0;
}