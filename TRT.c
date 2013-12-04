#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define max(a,b) (a>=b)?a:b

int *v,n,*res;

int F(int a,int b){
    if(res[a*n+b]!=-1){
        return res[a*n+b];
    }
    int age=a+n-b;
    if(a==b){
        return age*v[a];
    }
    
    int m1=age*v[a]+F(a+1,b);
    int m2=age*v[b]+F(a,b-1);
    res[a*n+b]=max(m1,m2);
    return res[a*n+b];
}

int main(){
    int i,j;
    res=(int *)malloc(sizeof(int)*4000000);
    memset(res,-1,sizeof(int)*4000000);
    
    scanf("%d",&n);
    v=(int *)malloc(sizeof(int)*n);
    for(i=0;i<n;i++){
        scanf("%d",&v[i]);
    }
    printf("%d\n",F(0,n-1));
    return 0;
}