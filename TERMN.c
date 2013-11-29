#include <stdio.h>
#include <stdlib.h>
int main(){int M=1300000,t,n=1,q,*P=(int *)malloc(sizeof(int)*M);long long int i;P[0]=P[1]=1;while(++n<M){for(t=2;!P[n]&&n*t<M;t++){P[n*t]=1;}}scanf("%d",&t);while(t--){scanf("%d",&n);q=i=0;while(q!=n){(!P[++i])?q++:0;}printf("%lld\n",(i-1)*(i-1));}return 0;}