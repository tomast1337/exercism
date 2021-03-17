#include <stdio.h>
#include <stdlib.h>
#define nConjuntos 6
#define numElem 5
#define numRelacoes 5
char index2Nome();
void printConjunto();
void printRelacoes();
struct Conjunto{
   char elementos[numElem];
   int tamanho;
};
struct Conjunto conjuntos[nConjuntos];
int main(void) {
   time_t t;
   srand((unsigned) time(&t));
   // Gerar, popular e imprimir conjuntos
   printf("\n\n\tConjuntos: \n");
   for(int indexC = 0; indexC < nConjuntos; indexC++){
       conjuntos[indexC].tamanho = (rand() % 4)+2;
       for (int i = 0; i < conjuntos[indexC].tamanho; i++)
           conjuntos[indexC].elementos[i] = (char)(rand() % 12)+65;
       printf("\t%c = ",index2Nome(indexC));
       printConjunto(&conjuntos[indexC]);
   }
   // Gerar e imprimir relações
   printf("\n\n\tRelações: \n");
   for(int indexC = 0; indexC < numRelacoes; indexC++){
       int iConj1 = rand() % nConjuntos;
       int iConj2 = rand() % nConjuntos;
       printf("\n\t%c e %c:\n",index2Nome(iConj1),index2Nome(iConj2));
       int relacoes[conjuntos[iConj1].tamanho][conjuntos[iConj2].tamanho];
       for(int i = 0;i < conjuntos[iConj1].tamanho;i++)
           for(int j = 0;j < conjuntos[iConj2].tamanho;j++)
               relacoes[i][j] = rand() % 2;
       printRelacoes(&relacoes[0][0], &conjuntos[iConj1], &conjuntos[iConj2]);
   }
}

char index2Nome(int index){ return (char)index+65; }
void printConjunto(struct Conjunto *conj){
    printf("{ ");
    for (int i = 0; i < conj->tamanho; i++)
        printf("%c ",conj->elementos[i]);
    printf("}\n");
}
void printRelacoes(int *relacoes,struct Conjunto *conjA,struct Conjunto *conjB){
    printf("\t ");
    for (int i = 0; i < conjA->tamanho; i++)
        printf(" %c",conjA->elementos[i]);
    putchar('\n');
    int reflexiva = 1, simetrica = 1, transitiva = 1;
    for (int i = 0; i < conjB->tamanho; i++){
        reflexiva *= *((relacoes+i*conjA->tamanho) + i);
        printf("\t%c",conjB->elementos[i]);
        for(int j = 0; j < conjA->tamanho; j++){
            printf(" %d", *((relacoes+i*conjA->tamanho) + j));
            if(*((relacoes+i*conjA->tamanho) + j) && *((relacoes+j*conjA->tamanho) + i))
                simetrica = 0;
            for(int k = 0,w = 0;;){
               if(*((relacoes+i*conjA->tamanho) + j) && *((relacoes+j*conjA->tamanho) + k) && !*((relacoes+i*conjA->tamanho) + w)) transitiva = 0;
               if(k < conjA->tamanho) k++;
               if(w < conjA->tamanho) w++;
               if(k >= conjA->tamanho && w >= conjA->tamanho) break;
            }
        }
        putchar('\n');
    }
  printf("reflexiva: %d\tsimetrica: %d\ttransitiva: %d\n",reflexiva,simetrica,transitiva);
}