#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_CHARS 31 // ## ######## #### #### #### ####

int main(int argc, char *argv[]){
    int nacc,i;
    int t;
    char *empty=(char *)malloc(sizeof(char));
    //scanf("%d",&t);
    gets(empty);//,3,stdin);
    t=atoi(empty);
    while(t--){
        //scanf("%d",&nacc);

        gets(empty);//,7,stdin);
        nacc=atoi(empty);

        if(nacc==0) {t++;continue;}

        char accounts[nacc][MAX_CHARS+1];
        
        int ctrl_digits,bank_code,owner1,owner2,owner3,owner4;

        for(i=0;i<nacc;i++){
            //scanf("%d %d %d %d %d %d",&ctrl_digits,&bank_code,&owner1,&owner2,&owner3,&owner4);
            //sprintf(accounts[i],"%02d %08d %04d %04d %04d %04d",ctrl_digits,bank_code,owner1,owner2,owner3,owner4);
            gets(accounts[i]);//,MAX_CHARS+2,stdin);
            *(accounts[i]+MAX_CHARS)='\0';
        }

        qsort(accounts,nacc,sizeof(char)*(MAX_CHARS+1),(int(*) (const void*,const void*)) strcmp);

        char *current_acc=accounts[0];
        int total_reps=1;

        for(i=1;i<nacc;i++){
            if(strcmp(accounts[i],current_acc)==0){
                total_reps++;
            }else{
                printf("%s %d\n",current_acc,total_reps);
                total_reps=1;
                current_acc=accounts[i];
            }
        }
        printf("%s %d\n",current_acc,total_reps);

        //for(i=0;i<nacc;i++){printf("%06d %s\n",(i+1),accounts[i]);}
        if(t!=0) printf("\n");
    }
    
    return 0;

}