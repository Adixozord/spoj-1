#include <stdio.h>
unsigned long long contar(unsigned long long n){
    unsigned long long r=0;
    r=n*(n+2)*(2*n+1);
    r-=(n%2);
    return r/8;
}
int main(){
    int t;
    unsigned long long n;
    scanf("%d",&t);
    while(t--){
        scanf("%llu",&n);
        printf("%llu\n",contar(n));
    }
    return 0;
}