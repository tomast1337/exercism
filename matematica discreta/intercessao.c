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
void intercessao_conjuntos(char *conjunto1, char *conjunto2, int tamanho1, int tamanho2){
   char resultado[tamanho1 + tamanho2];
   int tamanhoReal = 0;
   //Solução força bruta
   for(int i = 0; i < tamanho1; i++){
       for(int j = 0; j < tamanho2; j++){
           if (conjunto1[i]==conjunto2[j]){
               resultado[tamanhoReal] = conjunto2[j];
               tamanhoReal++;
           }
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
   char conjunto1[10] = {'1', 'a', '4', '1', '5', 'e', '8', 'b', '9', 'z'};
   char conjunto2[12] = {'1', 'd', 'w', 's', '1', 'i', '4', 'g', 'e', '8','p','o'};
   printf("\n\n\t\tA = ");
   print_conjunto(conjunto1, 10);
   printf("\n\t\tB = ");
   print_conjunto(conjunto2, 12);
   printf("\n\t\tA ∩ B = ");
   intercessao_conjuntos(conjunto1, conjunto2, 10, 12);
}