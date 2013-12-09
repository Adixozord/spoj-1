#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
void intToStr(int n){
    int r,q;
    int i=4;
    char *letras="ixcm";
    while(i--){
        q=n/(int) pow(10,i);r=n%(int) pow(10,i);
        if(q>0){
            if(q>1){
                printf("%d",q);
            }
            printf("%c",letras[i]);
        }
        n=r;
    }
    printf("\n");
}
int m(char c){
    switch(c){
        case 'm':return 1000;
        case 'c':return 100;
        case 'x':return 10;
        case 'i':return 1;
    }
}
int strToInt(char *mcxi){
    int n=0,i;
    int ln=strlen(mcxi);
    for(i=0;i<ln;){
        if(mcxi[i]>='0' && mcxi[i]<='9'){
            n+=(mcxi[i]-'0')*m(mcxi[i+1]);
            i+=2;
        }else{
            n+=m(mcxi[i++]);
        }
    }    
    return n;
}
int main(){
    int n;
    scanf("%d",&n);
    char *str1,*str2;
    str1=(char*)malloc(sizeof(char)*8);
    str2=(char*)malloc(sizeof(char)*8);
    while(n--){
        scanf("%s %s",str1,str2);
        intToStr(strToInt(str1)+strToInt(str2));
    }
    return 0;
}