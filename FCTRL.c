#include <stdio.h>

int main() {
    int i, t, n, cero, r, potencia;
    scanf("%d", &t);

    for (i = 0; i < t; i++) {
        cero = 0;
        potencia = 5;
        r = potencia;
        scanf("%d", &n);
        while (r > 0) {
            cero += (r = n / potencia);
            potencia *= 5;
        }
        printf("%d\n",cero);
    }
    return 0;
}