#include <stdio.h>

void print_conjunto(char *conjunto, int tamanho){
    putchar('{');
    for (int i = 0; i < tamanho; i++){
        putchar(conjunto[i]);
        putchar(' ');
    }
    printf("}");
}
void unir_conjuntos(char *conjunto1, char *conjunto2, int tamanho1, int tamanho2){
    char resultado[tamanho1 + tamanho2];
    int tamanhoReal = 0;

    //juntar conjuntos
    for (int i = 0; i < tamanho1; i++){
        resultado[i] = conjunto1[i];
        tamanhoReal++;
    }

    for (int i = tamanho1; i < tamanho1 + tamanho2; i++){
        resultado[i] = conjunto2[i - tamanho1];
        tamanhoReal++;
    }

    //remover elementos duplicados
    for (int i = 0; i < tamanhoReal; i++){
        for (int j = i + 1; j < tamanhoReal; j++){
            if (resultado[i] == resultado[j]){
                for (int k = j; k < tamanhoReal; k++){
                    resultado[k] = resultado[k + 1];
                }
                tamanhoReal--;
                j--;
            }
        }
    }
    //imprimir array
    print_conjunto(resultado, tamanhoReal);

    printf("\n\n\n");
}

int main(){
    char conjunto1[10] = {'1', 'a', '4', '1', '5', 'e', '8', 'b', '9', 'z'};
    char conjunto2[10] = {'2', 'a', '3', 'c', '6', 'd', '7', 'f', '3', 'b'};
    printf("\n\n\t\tA = ");
    print_conjunto(conjunto1, 10);
    printf("\n\t\tB = ");
    print_conjunto(conjunto2, 10);
    printf("\n\t\tA U B = ");
    unir_conjuntos(conjunto1, conjunto2, 10, 10);
}