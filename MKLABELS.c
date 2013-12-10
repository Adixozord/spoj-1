#include <stdio.h>
#include <math.h>
int main(){
    int n,j=0;
    while(1){
        scanf("%d",&n);
        if(n==0){break;}
        printf("Case %d, N = %d, # of different labelings = %.0f\n",++j,n,pow(n,n-2));
    }
    return 0;
}