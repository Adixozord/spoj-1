#include <stdio.h>
#include <stdlib.h>
int main(){
    int n,k,i,j=0;
    int res,power,g,x;
    int coefs[1000];
    int pts[100];
    while(1){
        scanf("%d",&n);
        if(n<0){break;}
        n++;
        
        for(i=n-1;i>=0;i--){
            scanf("%d",&coefs[i]);
        }
        
        scanf("%d",&k);
        for(i=0;i<k;i++){
            scanf("%d",&pts[i]);
        }

        printf("Case %d:\n",(++j));
        for(i=0;i<k;i++){
            res=0;
            power=1;
            for(g=0;g<n;g++){
                res+=coefs[g]*power;
                power*=pts[i];
            }
            printf("%d\n",res);
        }
    }
    return 0;
}