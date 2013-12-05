#include <stdio.h>
#include <stdlib.h>

#define MAX_TESTS 32000

int main() {
    int i, j, k, m, n, pass;
    int test_cases;
    int *mins, *maxs, *prime_tab;

    prime_tab = (int *) malloc(sizeof(int)*MAX_TESTS);
    
    prime_tab[0]=1;
    prime_tab[1]=1;

    for (i = 2; i < MAX_TESTS; i++) {
        if (!prime_tab[i]) {
            for (j = 2; i * j < MAX_TESTS; j++) {
                prime_tab[i * j] = 1;
            }
        }
    }

    scanf("%d", &test_cases);

    mins = (int *) malloc(sizeof(int) * test_cases);
    maxs = (int *) malloc(sizeof(int) * test_cases);

    for (i = 0; i < test_cases; i++) {
        scanf("%d %d", &mins[i], &maxs[i]);
    }
    
    for (k = 0; k < test_cases; k++) {
        m=mins[k];
        n=maxs[k];
        for (i = m; i <= n; i++) {
            pass = (i != 1);
            for ( j = 2; j * j <= i; j++) {
                if (!prime_tab[j]) {
                    if (i % j == 0) {
                        pass = 0;
                        break;
                    }
                }

            }
            if (pass){
                printf("%d\n",i);
            }
        }
        printf("\n");
    }
    return 0;
}