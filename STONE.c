#include <stdio.h>
#include <stdlib.h>

float signedArea(int n,float *x,float *y){
    float a=0;
    int i;
    for(i=0;i<=n-1;i++){
        a+=(x[i]*y[i+1]-x[i+1]*y[i]);
    }
    return a/2;
}

void coord(float n,float *x,float *y){
    int i;float cx=0,cy=0;
    float A=signedArea(n,x,y);

    for(i=0;i<=n-1;i++){
        cx+=(x[i]+x[i+1])*(x[i]*y[i+1]-x[i+1]*y[i]);
        cy+=(y[i]+y[i+1])*(x[i]*y[i+1]-x[i+1]*y[i]);
    }
    cx/=6*A;
    cy/=6*A;
    printf("%.2f %.2f\n",cx,    cy);
}

int main(){
    int T,N,i;
    float *xs,*ys;
    scanf("%d",&T);
    while(T--){
        scanf("%d",&N);
        xs=(float *)malloc(sizeof(float)*(N+1));
        ys=(float *)malloc(sizeof(float)*(N+1));
        for(i=0;i<N;i++){
            scanf("%f %f",&xs[i],&ys[i]);
        }
        xs[N]=xs[0];ys[N]=ys[0];
        coord(N,xs,ys);
        free(xs);free(ys);
    }
    return 0;
}