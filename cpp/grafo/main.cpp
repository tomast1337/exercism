#include <iostream>
template <typename Struct> struct Item{
    Struct dado;
    Item* proximo;
};
template <typename Struct> struct  Lista{
    Item<Struct>* cabeca;
    void remover(Item<Struct>* item){
        if(item == cabeca){
            Item<Struct>* antigo = cabeca;
            cabeca = cabeca->proximo == nullptr? cabeca = nullptr : cabeca->proximo;;
            delete antigo;
        }else{
            Item<Struct>* anterior = cabeca;
            while (anterior->proximo != nullptr && anterior->proximo != item){
                anterior = anterior->proximo;
            }
            if(anterior->proximo != nullptr){
                anterior->proximo = anterior->proximo->proximo;
                delete item;
            }
        }
    }
    void inserir(Struct* item){
        if(cabeca == nullptr){
            cabeca = item;
        }else{
            Item<Struct> ulitmo = cabeca;
            while (ulitmo->proximo != nullptr){
                ulitmo = ulitmo->proximo;
            }
            ulitmo.proximo = item;
        }
    }
};
struct Grafo{
    unsigned int numeroArestas;
    Lista<Lista<int>> listaListasAdjacencia;
    void adicionarAresta(int aresta){
        numeroArestas ++;
    }
    void removerAresta(int aresta){
        numeroArestas --;
    }
    Lista<int>* vizinhos(int aresta){
        return new Lista<int>();
    }
    bool TesteVizinhaca(int arestaA,int arestaB){
        return false;
    }

};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
