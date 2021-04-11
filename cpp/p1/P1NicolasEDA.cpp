/*
* P1 Estrutura de Dados
* Professora: Myrna Cecilia Martins Dos Santos Amorim 
* Aluno: Nicolas Vycas Nery
* Martricula: 2012383BCC
* Fiz a prova ultilizado o GNU Compiler Collection no linux então pode ter alguam diferença na aparencia de alguns caracteres ao ultilizar o prompt do windowns, oque é ruim porque fiz um menu bonitinho.
*/
#include <stdio.h>
#include <iostream>
#include <cstdlib>
#define nLugares 30

// alias para o ponteiro de Item 
typedef struct Item* ItemPtr;
// nó da lista
struct Item{ int codigo;
    float valor;
    ItemPtr proximo;
};

// Contra se o lugar esta livre e possui cabeça da lista
struct Cliente{ 
    ItemPtr cabeca = NULL;
    bool isLivre = true;
};

// Struct descrevendo o restaurante
struct Restaurante{ 
    Cliente cliente[nLugares];
    int lugaresUsados = 0;
    float montante = 0;
};
struct Restaurante restauranteSabores;

// Complexidade: O(1) 
void limpartela(){
    #ifdef WINDOWS // Macro para limpar a tela tanto no linux quando windowns
        std::system("cls");
    #else
        std::system ("clear");
    #endif
}

// Complexidade: O(1)
void inserir(int nCliente, int  codItem, float valor){
    // Eu não sei como alocar no c++ sem que seja um objeto, tive que usa o malloc por isso
    ItemPtr novo = (struct Item*) malloc(sizeof(struct Item));
    novo->codigo = codItem;
    novo->valor = valor;
    novo->proximo = NULL;
    if(restauranteSabores.cliente[nCliente].cabeca == NULL){
        restauranteSabores.cliente[nCliente].cabeca = novo;    
    }else{
        novo->proximo = restauranteSabores.cliente[nCliente].cabeca;
        restauranteSabores.cliente[nCliente].cabeca = novo;
    }
}

// Complexidade: O(n) onde n é o numero de lugares totais
void printClinetes(){ 
    printf("L = livre; O = Ocupado\n");
    for (int i = 0; i < nLugares; i++)
        printf("%02d:[%s]%s",i ,restauranteSabores.cliente[i].isLivre?"L":"O", (i+1) % 5 == 0?"\n":"\t ");
    printf("\n");
}

// Complexidade: O(1)
void entradaCliente(){ 
    if(restauranteSabores.lugaresUsados == nLugares){
        printf("\t\t\tTodos os lugares estão ocupados.\n");    
        return;
    }
    int nCliente; 
    printClinetes();
    printf("Selecione um lugar para o cliente.\nCliente n°:");
    std::cin>>nCliente;
    limpartela();
    if(restauranteSabores.cliente[nCliente].isLivre){
        restauranteSabores.cliente[nCliente].isLivre = false;
        restauranteSabores.lugaresUsados++;
        printf("\t\t\tCliente alocado no local %d\n",nCliente);
    }else
        printf("Local indisponivel selecione outro!\n");  
}

// Complexidade: O(n) onde n é o numero de itens na lista do cliente
void imprimirComanda(int nCliente){
    float total = 0;
        ItemPtr proximo = restauranteSabores.cliente[nCliente].cabeca; 
        while (proximo != NULL){
            total += proximo->valor;
            printf("%d\t%.2f\n",proximo->codigo,proximo->valor);
            proximo = proximo->proximo;
        }
        printf("Total: %.2f\n",total);
}

// Complexidade: O(n) onde n é o numero de itens na lista do cliente
void verificarConsumo(){
    if(restauranteSabores.lugaresUsados == 0){
        printf("\t\t\tO restaurante não tem clientes\n");    
        return;
    }
    int nCliente;
    float total = 0; 
    printClinetes();
    printf("Digite o número do cliente para ver o consumo.\nCliente n°:");
    std::cin>>nCliente;
    limpartela();
    if(restauranteSabores.cliente[nCliente].isLivre){
        printf("Não há nem um cliente no local %d\n",nCliente);
    }else{
        printf("O consumo do cliente ate agora foi:\n");
        imprimirComanda(nCliente);
    }
}

// Complexidade: O(n) onde n é o numero de itens na lista do cliente
float gerarNotaFiscal(int nCliente){
    float total = 0;
    if(restauranteSabores.cliente[nCliente].cabeca == NULL){
        printf("O cliente n° %d não comprou nada\n",nCliente);
    }else{
        printf("Cod\tValor\n");
        while (restauranteSabores.cliente[nCliente].cabeca != NULL){
            total += restauranteSabores.cliente[nCliente].cabeca->valor;
            printf("%d\t%.2f\n",restauranteSabores.cliente[nCliente].cabeca->codigo,restauranteSabores.cliente[nCliente].cabeca->valor);
            restauranteSabores.cliente[nCliente].cabeca = restauranteSabores.cliente[nCliente].cabeca->proximo;
        }
    }
    printf("Total a pagar: %.2f\n",total);
    return total;
}

// Complexidade: O(n) onde n é o numero de itens na lista do cliente
void saidaCliente(){
    if(restauranteSabores.lugaresUsados == 0){
        printf("\t\t\tO restaurante não tem clientes\n");    
        return;
    }
    int nCliente;
    printClinetes();
    printf("Digite o número do cliente que ira sair.\nCliente n°:");
    std::cin>>nCliente;
    limpartela();
    if(restauranteSabores.cliente[nCliente].isLivre){
        printf("Não há nem um cliente no local %d\n",nCliente);
    }else{
        restauranteSabores.montante += gerarNotaFiscal(nCliente); 
        restauranteSabores.lugaresUsados--;
        restauranteSabores.cliente[nCliente].isLivre = true;
        restauranteSabores.cliente[nCliente].cabeca = NULL;
        
    } 
}

// Complexidade: O(n) onde n é o numero de itens na lista do cliente
void consumoCliente(){
    int nCliente, codItem;
    float valorItem;
    printClinetes();
    printf("Digite o numero do cliente que sera adicionado um item.\nCliente n°:");
    std::cin>>nCliente;
    if(restauranteSabores.cliente[nCliente].isLivre){
        printf("Não há nem um cliente no local %d\n",nCliente);
    }else{
        printf("Digite o codigo do produto: ");
        std::cin>>codItem;
        printf("\nDigite o valor do produto: ");
        std::cin>>valorItem;
        inserir(nCliente,codItem,valorItem);
        limpartela();
        printf("\nInserido item de codigo %d e preço R$%.2f a comando do cliente n° %d\n",codItem,valorItem,nCliente);
    }
}

// Complexidade: O(1) 
bool menu(){
    int opcao;
    printf("\t\t\t=============================\n");   
    printf("\t\t\t╔═══╗     ╔╗                 \n");  
    printf("\t\t\t║╔═╗║     ║║                 \n");  
    printf("\t\t\t║╚══╗╔══╗ ║╚═╗╔══╗╔═╗╔══╗╔══╗\n");  
    printf("\t\t\t╚══╗║╚ ╗║ ║╔╗║║╔╗║║╔╝║╔╗║║══╣\n");  
    printf("\t\t\t║╚═╝║║╚╝╚╗║╚╝║║╚╝║║║ ║║═╣╠══║\n");    
    printf("\t\t\t╚═══╝╚═══╝╚══╝╚══╝╚╝ ╚══╝╚══╝\n");
    printf("\t\t\t=============================\n");
    printf("\t\t  1 - Entrada Cliente 2 - Saida Cliente\n");
    printf("\t\t  3 - Consumo Cliente 4 - Verificar Consumo\n");
    printf("\t\t\t\t0 - Finalizar Programa\n");
    printf("\t\t\t\tDigite sua opção: ");
    std::cin>>opcao;
    switch(opcao) {
            case 0:// Finalizar programa
                if(restauranteSabores.lugaresUsados == 0){
                    printf("\n\t\t\t\tMontante do dia: R$%.2f\n\n\t\t\t\tSaindo...\n",restauranteSabores.montante);
                    return false;
                }else{
                    limpartela();
                    printf("\n\t\t\tAinda tem clientes que não sairam!\n");
                    return true;
                }
            break;
            case 1:// Entrada cliente
                limpartela();
                entradaCliente();
                return true;
            break;
            case 2:// Saida cliente
                limpartela();
                saidaCliente();
                return true;
            break;
            case 3:// Consumo Cliente
                limpartela();
                consumoCliente();
                return true;
            case 4:// Verificar Consumo Cliente
                limpartela();
                verificarConsumo();
                return true;
            break;
            default:
                limpartela();
                printf("\n\t\t      Opção invalida. Tente novamente!\n");
                return true;
            break;
        }
}

int main(){ // Complexidade: A função não possui entrada 
    limpartela();
    while(menu());
}