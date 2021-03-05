#include <stdio.h>

void print_conjunto(char *conjunto, int tamanho){
    putchar('{');
    for (int i = 0; i < tamanho; i++){
        if(i == tamanho-1){
            putchar(conjunto[i]);
        }else{
            putchar(conjunto[i]);
            printf(", ");;
        }
    }
    printf("}");
}

void uniao_disjunta(char *conjunto1, char *conjunto2, int tamanho1, int tamanho2){
    char uniao[tamanho1 + tamanho2];
    int tamanhoReal = 0;
    //Uniao
    for (int i = 0; i < tamanho1; i++){
        uniao[i] = conjunto1[i];
        tamanhoReal++;
    }

    for (int i = tamanho1; i < tamanho1 + tamanho2; i++){
        uniao[i] = conjunto2[i - tamanho1];
        tamanhoReal++;
    }
    //remover elementos duplicados
    for (int i = 0; i < tamanhoReal; i++){
        for (int j = i + 1; j < tamanhoReal; j++){
            if (uniao[i] == uniao[j]){
                for (int k = j; k < tamanhoReal; k++){
                    uniao[k] = uniao[k + 1];
                }
                tamanhoReal--;
                j--;
            }
        }
    }
    
    print_conjunto(uniao, tamanhoReal);
}

int main(){
    char conjunto1[10] = {'1', 'h', '4', 'l', '5', '1', '2', 'b', '7', 'z'};
    char conjunto2[12] = {'1', '7', '6', 'u', '1', 'i', '4', 'j', 'e', '8','p','o'};
    printf("\n\n\t\tA = ");
    print_conjunto(conjunto1, 10);
    printf("\n\t\tB = ");
    print_conjunto(conjunto2, 12);
    printf("\n\t\tA U B = ");
    uniao_disjunta(conjunto1, conjunto2, 10, 12);
    printf("\n\n\n");
}