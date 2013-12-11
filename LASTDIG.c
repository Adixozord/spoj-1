#include <stdio.h>
#include <string.h>
int main(){
    char *dig[10]={"0","1","2486","3971","46","5","6","7931","8426","91"};
    int  ldig[10]={1,1,4,4,2,1,1,4,4,2};
    int t,a,b,pos;
    scanf("%d",&t);
    while(t--){
        scanf("%d %d",&a,&b);
        if(!b){printf("1\n");continue;}
        a%=10;
        pos=((b%ldig[a])-1)%ldig[a];
        if(pos<0){pos+=ldig[a];}
        printf("%d\n",dig[a][pos]-'0');
    }
    return 0;
}