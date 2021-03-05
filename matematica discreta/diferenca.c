#include <stdio.h>
#include<stdbool.h>

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
void diferenca_conjuntos(char *conjunto1, char *conjunto2, int tamanho1, int tamanho2){
   char resultado[tamanho1+tamanho2];
   int tamanhoReal = 0;
   //Solução força bruta
   for(int i = 0; i < tamanho1; i++){
       bool contem = false;
       for(int j = 0; j < tamanho2; j++) contem = conjunto1[i] == conjunto2[j] || contem;
       if(!contem){
           resultado[i] = conjunto1[i];
           tamanhoReal++;
       }
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
   char conjunto1[5] = {'p', 'a', '4', '1', '5'};
   char conjunto2[5] = {'1', 'd', 'w', 's', '1'};
   printf("\n\n\t\tA = ");
   print_conjunto(conjunto1, 5);
   printf("\n\t\tB = ");
   print_conjunto(conjunto2, 5);
   printf("\n\t\tA U B = ");
   diferenca_conjuntos(conjunto1, conjunto2, 5, 5);
}