#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
    int l,t,key;
    int new,i;
    char *S=(char *)malloc(sizeof(char)*100002);
    scanf("%d",&t);
    while(t--){
        scanf("%d",&key);
        scanf("%s",S);
        l=strlen(S);
        for(i=0;i<l;i++){
            if(S[i]=='.'){
                new=' ';
            }else{
                new=S[i]+(key%26);
                if(new>122 && S[i]<=122 && S[i]>=97){
                    new=96+(new%122);
                }
                if(new>90 && S[i]<=90 && S[i]>=65){
                    new=64+(new%90);
                }
                if(key>25){
                    if(new>96){new-=32;}
                    else if(new>64){new+=32;}
                }
            }
            printf("%c",new);
        }
        printf("\n");
    }
    return 0;
}