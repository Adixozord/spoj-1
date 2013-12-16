#include <stdio.h>
int digits[2][10];
int powers10[10];

void contar(int numero,int sup){
    int d,dcnt=0,i,r0=0,v,r=0;
    while(numero){
        d=numero%10;numero/=10;
        if(dcnt){
            v=d*powers10[dcnt-1]*dcnt;
            for(i=0;i<10;i++){digits[sup][i]+=v;}
            if(!d){
                r0+=powers10[dcnt]-1-r;
            }
        }
        v=powers10[dcnt];
        for(i=1;i<d;i++){digits[sup][i]+=v;}
        if(d){digits[sup][d]+=r+1;}
        r=powers10[dcnt++]*d +r;
    }
    digits[sup][0]-=r0;
}

int main(){
    int a,b,tmp,i,j,nines,power,prefix;
    powers10[0]=1;
    for(i=1;i<10;i++){powers10[i]=10*powers10[i-1];}

    while(scanf("%d %d",&a,&b) && a|b!=0){
        if(a>b){tmp=a;a=b;b=tmp;}
        for(i=0;i<10;i++){digits[1][i]=0;digits[0][i]=0;}

        contar(b,1);
        contar(a-1,0);

        for(i=0;i<10;i++){
            printf("%d\t",digits[1][i]-digits[0][i]);
        }
        printf("\n");
    }
}