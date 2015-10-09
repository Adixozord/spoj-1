#include <stdio.h>
#include <stdlib.h>

int main(){
    int t,n,s,i,maxSum;
    scanf("%d",&t);
    while(t--){
        scanf("%d %d",&n,&s);

        maxSum=n*(n-1)/2;

        if(abs(s)>maxSum ||
            (abs(s) & 1) != (maxSum & 1)){
            printf("No\n");
            continue;
        }

        i=0;

        while(n--){
            printf("%d\n",i);
            if(s+n > n*(n-1)/2){
                s-=n;
                i++;
            }else{
                s+=n;
                i--;
            }
        }
    }
    return 0;
}