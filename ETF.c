#include <stdio.h>
#include <stdlib.h>

#define MAX_TESTS 1000000
int totient(int n){
    int i,result=n;
    for(i=2;i*i<=n;i++){
        if(n%i==0){
            result-=result/i;
        }
        while(n%i==0){
            n/=i;
        }
    }
    if(n>1){result-=result/n;}
    return result;
}
int main() {
    int t,n;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        printf("%d\n",totient(n));
    }
    return 0;
}