#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// clang set.c && ./a.out

struct No {
    int valor;
    struct No *next;
};
typedef struct No No;

typedef struct {
    No *raiz;
} Conjunto;

void inserir (Conjunto * con, int valor){
    No *no = con->raiz;
    No *ant = NULL;
    while (no != NULL && no->valor < valor){
        ant = no;
        no = no->next;
    }
    if (no == NULL || no->valor != valor){
        No *novo = (No *) malloc(sizeof(No));
        novo->valor = valor;
        novo->next = no;
        if (ant == NULL)
            con->raiz = novo;
        else
            ant->next = novo;
    }
}

int con_contem (Conjunto * con, int valor){
    No *no = con->raiz;
    while (no != NULL && no->valor < valor)
        no = no->next;
    return no != NULL && no->valor == valor;
}

void imprimir (Conjunto * set){
    No *no = set->raiz;
    printf("📦 { ");
    while (no != NULL){
        if (no->next != NULL)
            printf("%c, ", no->valor );
        else
            printf("%c ", no->valor );
        no = no->next;
    }
    printf("} \n");
}

Conjunto * Junção (Conjunto * set1, Conjunto * set2){
    Conjunto *novo = (Conjunto *) malloc(sizeof(Conjunto));
    novo->raiz = NULL;
    No *no = set1->raiz;
    while (no != NULL){
        inserir(novo, no->valor);
        no = no->next;
    }
    no = set2->raiz;
    while (no != NULL){
        inserir(novo, no->valor);
        no = no->next;
    }
    return novo;
}

Conjunto * Interseção (Conjunto * set1, Conjunto * set2){
    Conjunto *novo = (Conjunto *) malloc(sizeof(Conjunto));
    novo->raiz = NULL;
    No *no = set1->raiz;
    while (no != NULL){
        if (con_contem(set2, no->valor))
            inserir(novo, no->valor);
        no = no->next;
    }
    return novo;
}

int main(){
    Conjunto *set1 = (Conjunto *) malloc(sizeof(Conjunto));
    Conjunto *set2 = (Conjunto *) malloc(sizeof(Conjunto));
    srand(time(NULL));
    for (int i = 0; i < 10; i++){
        inserir(set1, rand() % 26 + 65);
        inserir(set2, rand() % 26 + 65);
    }

    printf("Conjunto 1 = ");
    imprimir(set1);
    printf("Conjunto 2 = ");
    imprimir(set2);


    Conjunto *set3 = Junção(set1, set2);
    printf("\nJunção entre Conjunto 1 e Conjunto 2 = ");
    imprimir(set3);

    Conjunto *set4 = Interseção(set1, set2);
    printf("\nInterseção entre Conjunto 1 e Conjunto 2 = ");
    imprimir(set4);

    return EXIT_SUCCESS;
}
