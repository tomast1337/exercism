/*
* Trabalho 3 EDA
* Professora: Myrna Cecilia Martins Dos Santos Amorim 
* Aluno: Nicolas Vycas Nery
* Martricula: 2012383BCC
*/
#include <iostream>

typedef struct Item* ItemPtr;
struct Item{
    int valor;
    ItemPtr proximo;
};

typedef struct Lista* ListaPtr;
struct Lista{
    ItemPtr cabeca;
};

ItemPtr get_Fim(ListaPtr lista){
   ItemPtr ultimo = lista->cabeca;
    while(ultimo->proximo != lista->cabeca)
        ultimo = ultimo->proximo;
    return ultimo;
}

void inserirInicio(ListaPtr lista,ItemPtr item){
    if(lista->cabeca == NULL){
        item->proximo = item;
        lista->cabeca = item;
    }else{
        ItemPtr ultimo = get_Fim(lista);
        ultimo->proximo = item;
        item->proximo = lista->cabeca;
        lista->cabeca = item;
    }
}

void inserirFim(ListaPtr lista,ItemPtr item){
    if(lista->cabeca == NULL){
        item->proximo = item;
        lista->cabeca = item;
    }else{
        ItemPtr ultimo = get_Fim(lista);
        ultimo->proximo = item;
        item->proximo = lista->cabeca;
    }
}

void removerInicio(ListaPtr lista){
    ItemPtr item = lista->cabeca;
    if(item != NULL){
        if(lista->cabeca == lista->cabeca->proximo){
            delete lista->cabeca;
            lista->cabeca = NULL;
        }else{
            ItemPtr cabecaAntiga = lista->cabeca;        
            ItemPtr proximo = lista->cabeca->proximo;
            ItemPtr ultimo = get_Fim(lista);
            lista->cabeca = proximo;
            ultimo->proximo = proximo;
            delete cabecaAntiga;
        }
    }
}

void removerFim(ListaPtr lista){
    ItemPtr ultimo = lista->cabeca;
    if(ultimo != NULL){
        if(lista->cabeca == lista->cabeca->proximo){
            delete lista->cabeca;
            lista->cabeca = NULL;
        }else{
            ItemPtr ultimo = get_Fim(lista);
            ItemPtr penultimo = lista->cabeca;
            while(penultimo->proximo != ultimo)
                penultimo = penultimo->proximo;
            penultimo->proximo = lista->cabeca;
            delete ultimo;
        }
    }
}

void printLista(ListaPtr lista){
    ItemPtr item = lista->cabeca;
    if(item == NULL)
        std::cout<<"Lista vazia!\n";
    else{
        std::cout<<"...->";
        for(ItemPtr item = lista->cabeca; item->proximo != lista->cabeca; item = item->proximo)
            std::cout<<"["<<item->valor<<"]->";
        std::cout<<"["<<get_Fim(lista)->valor<<"]->";
        std::cout<<"...";
    }
}

bool menu(ListaPtr lista){
    int opcao,valor;
    std::cout<<"\n\n\t\t0-Inserir Inicio\t\t1-Inserir Fim\t\t2-Remover Inicio\n\t\t3-Remover Fim\t\t\t4-Imprimir\t\t5-Sair\n\n\t\tDigite sua opção: "; 
    std::cin>>opcao;
    switch(opcao) {
        case 0:{
            std::cout<<"\nDigite o valor inteiro a ser inserio no começo da lista: ";
            std::cin>> valor;
            ItemPtr item = new Item;
            item->valor = valor;
            inserirInicio(lista,item);
            printLista(lista);
            return true;
        }
        break;
        case 1:{
            std::cout<<"\n\tDigite o valor inteiro a ser inserio no fim da lista: ";
            std::cin>> valor;
            ItemPtr item = new Item;
            item->valor = valor;
            inserirFim(lista,item);
            printLista(lista);
            return true;
        }
        break;
        case 2:
            std::cout<<"\n\tRemovendo valor do inicio da lista:\n\t Antes: ";
            printLista(lista);
            removerInicio(lista);
            std::cout<<"\n\t Agora: ";
            printLista(lista);
            return true;
        break;
        case 3:
            std::cout<<"\n\tRemovendo valor do fim da lista:\n\t Antes: ";
            printLista(lista);
            removerFim(lista);
            std::cout<<"\n\t Agora: ";
            printLista(lista);
            return true;
        break;
        case 4:
            std::cout<<"\n\tLista: ";
            printLista(lista);
            return true;
        break;
        case 5:
            std::cout<<"\nSaindo...\n";
            return false;
        break;
        default:
            std::cout<<"\n\tOpção invalida. Tente novamente!\n";
            return true;
        break;
    }
    return true;
}

int main(){
    ListaPtr lista = new Lista;
    while(menu(lista));
}