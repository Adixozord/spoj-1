#include <stdio.h>
int p(int n){
    int r=2;
    while(--n){
        r*=2;
    }
    return r;
}
int facto(int n){
    int p=1,i;
    for(i=2;i<=n;i++){
        p*=i;
    }
    return p;
}

int main(){
    int n;
    scanf("%d",&n);
    printf("%d\n",facto(n)-n+p(n));
    return 0;
}