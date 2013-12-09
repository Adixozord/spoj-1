#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define M 20000

int main(){

    int n,i;
    int q,r;
    int A[M];
    for(i=0;i<M;i++){A[i]=1;}

    printf("2.");

    n=M-1;
    while(--n){
        for(i=0;i<M;i++){A[i]*=10;}

        for(i=M-1;i>=1;i--){
            A[i-1]+=A[i]/(i+2);

            q=A[i]/(i+2);
            A[i]%=(i+2);
        }
        printf("%d",A[0]/2);
        A[0]%=2;
    }

    return 0;
}