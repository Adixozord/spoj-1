#include <stdio.h>
#include <math.h>

int main(int argc,char **argv){

    int t;

    double ab,ac,ad,bc,bd,cd;
    double xc,yc;
    double xd,yd,zd;

    double s,area_base;

    scanf("%d",&t);

    while(t--){
        scanf("%lf %lf %lf %lf %lf %lf",&ab,&ac,&ad,&bc,&bd,&cd);
    
        xc=(ab*ab+ac*ac-bc*bc)/(2.0*ab);
        yc=sqrt(ac*ac-xc*xc);

        xd=(ab*ab+ad*ad-bd*bd)/(2.0*ab);
        yd=(cd*cd-bd*bd-((xc-xd)*(xc-xd)) + ((ab-xd)*(ab-xd)) - yc*yc )/(-2.0*yc);
        zd=sqrt(cd*cd-((xc-xd)*(xc-xd)) - ((yc-yd)*(yc-yd)));

        s=(ab+bc+ac)/2.0;
        
        area_base=sqrt(s*(s-ab)*(s-ac)*(s-bc));

        printf("%.4f\n",area_base*zd/3.0);

    }
    return 0;
}
