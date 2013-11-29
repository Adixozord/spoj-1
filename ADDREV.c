#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *reverse(char *src,int n){
    char *rev=(char *)malloc(sizeof(char)*n);
    int i;
    for(i=0;i<n;i++){
        *(rev+i)=*(src+n-1-i);
    }

    while(*rev=='0'){
        *rev++;
    }
    return rev;
}

char *sumar(char *a,char *b){
    char *reva=reverse(a,strlen(a));
    char *revb=reverse(b,strlen(b));
    char *revsuma=(char *)malloc(sizeof(char)*9);
    sprintf(revsuma,"%lld",atoll(reva)+atoll(revb));
    return revsuma;
}

int main(){

    int N,a,b,i;
    scanf("%d",&N);

    char *stra=(char *)malloc(sizeof(char)*9);
    char *strb=(char *)malloc(sizeof(char)*9);

    char *sums[N];

    for(i=0;i<N;i++){
        scanf("%d %d",&a,&b);
        
        sprintf(stra,"%d",a);
        sprintf(strb,"%d",b);
           
        sums[i]=(char *)malloc(sizeof(char)*9);
        sums[i]=sumar(stra,strb);
    }

    for(i=0;i<N;i++){
        printf("%s\n",reverse(sums[i],strlen(sums[i])));
    }

    free(stra);free(strb);

    return 0;
}
