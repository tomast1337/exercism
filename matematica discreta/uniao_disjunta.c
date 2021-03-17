#include <stdio.h>

void print_conjunto(char *conjunto, int tamanho){
    printf("{");
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
    char resultado[tamanho1 + tamanho2];
    int tamanhoReal = 0;
    for(int i = 0; i < tamanho1; i++){
        for(int j = 0; j <tamanho2; j++){
            if(conjunto1[i] == conjunto2[j]){
                break;
            }else if(j == (tamanho2-1)){
            resultado[tamanhoReal] = conjunto1[i];
            tamanhoReal++;
        }
        }
    }
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
    print_conjunto(resultado, tamanhoReal);
}

int main(){
    char conjunto1[12] = {'2','a','5','v','8','f','5','a','3','a','5','a'};
    printf("\nA = ");
    print_conjunto(conjunto1, 12);
    
    char conjunto2[12] = {'a','5','c','2','g','8','t','r','7','a','4','a'};
    printf("\nB = ");
    print_conjunto(conjunto2, 12);
    
    printf("\nuniao_disjunta(A,B) = ");
    uniao_disjunta(conjunto1, conjunto2, 12, 12);
    printf("\n");
}