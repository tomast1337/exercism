#include <iostream>
typedef struct Item* ItemPtr;
struct Item{
    int valor;
    ItemPtr proximo;
    ItemPtr anterior;
};
typedef struct Lista* ListaPtr;
struct Lista{
    ItemPtr cabeca;
};
void inserirInicio(ListaPtr lista,ItemPtr item){
    if(lista->cabeca == NULL){
        lista->cabeca = item;
    }else{
        item->proximo = lista->cabeca;
        lista->cabeca->anterior = item;
        lista->cabeca = item;
    }
}
void inserirFim(ListaPtr lista,ItemPtr item){
    ItemPtr ultimo = lista->cabeca;
    while(ultimo->proximo != NULL)
        ultimo = ultimo->proximo;
    item->anterior = ultimo;
    ultimo->proximo = item;
}
void removerInicio(ListaPtr lista){
    ItemPtr item = lista->cabeca;
    if(item == NULL)
        std::cout<<"Lista vazia";
    else{
        ItemPtr primeiro = lista->cabeca;
        lista->cabeca = primeiro->proximo;
        lista->cabeca->anterior = NULL;
        delete primeiro;
    }
}
void removerFim(ListaPtr lista){
    ItemPtr ultimo = lista->cabeca;
    if(ultimo == NULL)
        std::cout<<"Lista vazia\n";
    else{
        while(ultimo->proximo != NULL)
            ultimo = ultimo->proximo;
        ItemPtr anterior = ultimo->anterior;
        anterior->proximo = NULL;
        delete ultimo;
    }
}
void printLista(ListaPtr lista){
    ItemPtr item = lista->cabeca;
    if(item == NULL)
        std::cout<<"Lista vazia\n";
    else
        for(ItemPtr item = lista->cabeca;item != NULL; item = item->proximo)
            std::cout<<"["<<item->valor<<"] ";
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
            return true;
        }
        break;
        case 1:{
            std::cout<<"\n\tDigite o valor inteiro a ser inserio no fim da lista: ";
            std::cin>> valor;
            ItemPtr item = new Item;
            item->valor = valor;
            inserirFim(lista,item);
            return true;
        }
        break;
        case 2:
            std::cout<<"\n\tRemovendo valor do inicio da lista:\n Antes: ";
            printLista(lista);
            removerInicio(lista);
            std::cout<<"\n\t Agora: ";
            printLista(lista);
            return true;
        break;
        case 3:
            std::cout<<"\n\tRemovendo valor do fim da lista:\n Antes: ";
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
    std::cout<<"\nSaindo...\n";
}