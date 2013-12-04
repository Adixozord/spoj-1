#include <stdio.h>

int main(){
    float c,r;
    int i;
    while(1){
        scanf("%f",&c);
        if(!c){break;}
        r=.5;
        i=3;
        while(r<c){r+=1.0/(i++);}
        printf("%d card(s)\n",i-2);
    }
    return 0;
}