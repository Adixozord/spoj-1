#include<stdio.h>
#include<stdlib.h>
int main(){
int t=10;char *p=(char *)malloc(sizeof(char)*20);
while(t--){int n=1;
scanf("%s",p);
while(*p){{n*=((*p=='F'||*p=='L'||*p=='T'||*p=='D')?2:1);}*p++;}
printf("%d\n",n);
}return 0;}