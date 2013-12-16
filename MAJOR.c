#include <stdio.h>

int main(){
    int i,t,n,m,min;
    scanf("%d",&t);
    int data[2001];
    while(t--){
        for(i=0;i<2001;i++){data[i]=0;}
        scanf("%d",&n);
        min=n/2;
        for(i=0;i<n;i++){
            scanf("%d",&m);
            data[m+1000]++;
        }
        m=-1001;
        for(i=0;i<2001;i++){
            if(data[i]>min){
                m=i-1000;
                break;
            }
        }
        if(m>-1001){
            printf("YES %d\n",m);
        }else{
            printf("NO\n");
        }
    }
    return 0;
}