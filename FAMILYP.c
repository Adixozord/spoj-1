#include <stdio.h>
#include <stdlib.h>

int main(){
    char *letras=(char *)malloc(sizeof(char)*1000000);
    int i,inc=1;
    int limit=1,grupo=0;
    int input=0;
    char nada;
    for(i=0;i<1000000;i++){
        letras[i]='A'+(grupo%26);
        limit--;
        if(limit==0){
            grupo++;
            limit=++inc;
        }
    }
    
    while(scanf("%d",&input)!=EOF){
        printf("TERM %d IS %c\n",input,letras[input-1]);
    }
    
    return 0;
}