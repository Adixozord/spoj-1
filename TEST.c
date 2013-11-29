#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int x=0;
    char num[3],*input;
    input=(char *)malloc(sizeof(char)*100);
    int count=0;
    while(1) {
        scanf("%d", &x);
        if(x==42){
            break;
        }
        sprintf(num,"%d",x);
        strcat(input,num);
        strcat(input,"\n");
    }
    printf("\n");
    printf("%s",input);

    return 0;
}