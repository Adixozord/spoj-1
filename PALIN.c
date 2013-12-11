#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int isPalindrome(char *numero) {
    int i, j;
    int n = strlen(numero);
    int mitad = n / 2;
    int palindrome = 1;
    if (n % 2) {
        mitad++;
    }
    for (i = 0; i < mitad && palindrome; i++) {
        palindrome = palindrome && (numero[i] == numero[n - 1 - i]);
    }
    return palindrome;
}

char *incrementFromMiddle(char *numero) {
    int i, j, puntero, llevo, temp;
    int n = strlen(numero);
    int mitad = (n / 2) - 1;
    char temp_char, *result = (char *) malloc(sizeof(char) * (n + 1));
    char uno[1000001] = "1";
    char inc;
    if (n % 2) {
        mitad++;
    }
    llevo = 0;
    puntero = mitad;

    temp_char = numero[puntero];
    temp = atoi(&temp_char);

    if (temp == 9) {
        llevo = 1;
        temp = 0;
    } else {
        temp++;
    }
    sprintf(&temp_char, "%d", temp);
    result[puntero] = temp_char;

    puntero--;
    while (puntero >= 0) {
        temp_char = numero[puntero];
        temp = atoi(&temp_char);
        if (temp == 9) {
            if (llevo) {
                temp = 0;
            }
        } else {
            if (llevo) {
                temp++;
                llevo = 0;
            }
        }
        sprintf(&temp_char, "%d", temp);
        result[puntero] = temp_char;
        puntero--;
    }

    puntero = mitad + 1;
    while (puntero < n) {
        temp_char = numero[puntero];
        temp = atoi(&temp_char);
        sprintf(&temp_char, "%d", temp);
        result[puntero] = temp_char;
        puntero++;
    }

    if (llevo) {
        strcat(uno, result);
        result = uno;
    }

    return result;
}

char *mirror(char *s) {
    int n = strlen(s);
    char *result = (char *) malloc(sizeof(char) * n);
    int midpoint = n / 2;
    int i = n % 2 == 0 ? midpoint : midpoint + 1;
    strcpy(result, s);
    while (i < n) {
        result[i] = s[midpoint - 1];
        i++;
        midpoint--;
    }
    return result;
}

char *getNextPalindrome(char *s) {
    char *mirrored = mirror(s);

    //the mirror might be smaller than original, so increment it and try again.
    if (strcmp(mirrored, s) <= 0) {
        mirrored = mirror(incrementFromMiddle(s));
    }

    return mirrored;
}

int main() {
    int i, t;
    char **k;
    scanf("%d", &t);
    k = (char **) malloc(sizeof(char) * 1000000 * t);
    for (i = 0; i < t; i++) {
        k[i] = (char *) malloc(sizeof(char) * 1000000);
        scanf("%s", k[i]);
    }
    printf("\n");
    for (i = 0; i < t; i++) {
        printf("%s\n", getNextPalindrome(k[i]));
    }
    return 0;
}