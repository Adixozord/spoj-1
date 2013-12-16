#include <stdio.h>
int main(){
    int n,i,j;
    int rects[10001];
    rects[0]=0;
    for(i=1;i<10001;i++){
        rects[i]=rects[i-1];
        for(j=1;j*j<=i;j++){
            if(i%j==0){
                rects[i]++;
            }
        }
    }
    scanf("%d",&n);
    printf("%d\n",rects[n]);
    return 0;
}