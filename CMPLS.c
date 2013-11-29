#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int allEqual(int *secuencia,int terminos){
    int i;
    if(terminos>1){
        for(i=0;i<terminos-1;i++){
            if(secuencia[i]!=secuencia[i+1]){
                return 0;
            }
        }
    }
    return 1;
}

void procesar(int *secuencia,int terminos,int terminosNuevos){
    if(terminosNuevos){
        int *diffs=(int *)malloc(sizeof(int)*terminos);
        int *secNueva=(int *)malloc(sizeof(int)*(terminos+1));
        int diff=0;
        int i;
        int terminosDerivados=terminos;
        for(i=0;i<terminos;i++){
            diffs[i]=secuencia[i];
            secNueva[i]=secuencia[i];
        }

        while(!allEqual(diffs,terminosDerivados)){

            for(i=0;i<terminosDerivados;i++){
                diffs[i]=diffs[i+1]-diffs[i];
            }
            diff+=diffs[terminosDerivados-2];
            
            terminosDerivados--;
        }
        diff+=secuencia[terminos-1];

        printf("%d ",diff);

        secNueva[terminos]=diff;
        procesar(secNueva,terminos+1,terminosNuevos-1);
        free(diffs);free(secNueva);
    }  
}

int main(){
    int T,S,C,i;
    int *seqOriginal;
    
    scanf("%d",&T);
    while(T){
        scanf("%d %d",&S,&C);
        seqOriginal=(int *)malloc(sizeof(int)*S);
        
        for(i=0;i<S;i++){
            scanf("%d",&seqOriginal[i]);
        }
        
        procesar(seqOriginal,S,C);

        printf("\n");

        T--;
        free(seqOriginal);
    }

    return 0;
}

