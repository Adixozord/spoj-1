#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXDIGITS 5000

int *dp;

int decode(char *n,int N){
    int i;
    int dos_digitos=0;
    for(i=1;i<N;i++){
        if(*(n+i)!='0'){
            dp[i]=dp[i-1];
        }
        dos_digitos=10*(*(n+i-1)-'0')+(*(n+i)-'0');
        if(dos_digitos>9 && dos_digitos<27){
            dp[i]+=((i!=1)?dp[i-2]:1);
        }
    }
}

int main(){
    char *n=(char *)malloc(sizeof(char)*MAXDIGITS);
    dp=(int *)malloc(sizeof(int)*MAXDIGITS);
    int N;
    while(1){
        memset(dp,0,sizeof(int)*MAXDIGITS);
        dp[0]=1;
        scanf("%s",n);
        if(*n=='0'){break;}
        N=strlen(n);
        decode(n,N);
        printf("%d\n",dp[N-1]);
    }
    return 0;
}