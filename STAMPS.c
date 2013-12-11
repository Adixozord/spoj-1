#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cmp(const void *a,const void *b){
    return (*(int *)b)-(*(int *)a);
}

int main(){
    int sum,i,t,stamps,friends,j=0;
    scanf("%d",&t);
    while(t--){
        scanf("%d %d",&stamps,&friends);
        int fstamps[friends];
        for(i=0;i<friends;i++){
            scanf("%d",&fstamps[i]);
        }
        qsort(fstamps,friends,sizeof(int),cmp);
        sum=0;
        printf("Scenario #%d:\n",++j);
        for(i=0;i<friends;i++){
            sum+=fstamps[i];
            if(sum>=stamps){
                printf("%d\n",i+1);
                break;
            }
        }
        if(sum<stamps){printf("impossible\n");}

        printf("\n");
    }
    return 0;
}