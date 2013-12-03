#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
    char *code=(char *)malloc(sizeof(char)*200);
    char *matriz=(char *)malloc(sizeof(char)*200);
    int N,to,col,i,j,fila;
    while(1){
        to=1;
        fila=0;
        scanf("%d",&col);
        if(!col){break;}
        scanf("%s",code);
        N=strlen(code);
        memset(matriz,0,sizeof(char)*200);
        for(i=0;i<N;i++){
            if(to){
                *(matriz+i)=*(code+i);
            }else{
                *(matriz+(fila+1)*col-(i%col)-1)=*(code+i);
            }
            if((i+1)%col==0){
                to=(to+1)%2;
                fila++;
            }
        }
        
        fila=N/col;
        for(i=0;i<col;i++){
            for(j=0;j<fila;j++){
                printf("%c",matriz[j*col+i]);
            }
        }
        printf("\n");
    }
    return 0;
}