#include <iostream>
template <typename Struct> struct Item{
    Struct dado;
    Item* proximo;
    Item(){}
    Item(Struct dado){
        this->dado = dado;
    }
    Item(Struct dado,Item* proximo){
        this->proximo = proximo;
        this->dado = dado;
    }
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
    Item<Struct>* ultimo(){
        Item<Struct>* ultimo = cabeca;
        while (ultimo->proximo != nullptr)
            ultimo = ultimo->proximo;
        return ultimo;
    }
};
struct Grafo{
    int numeroArestas;
    Lista<Lista<char>> listaListasAdjacencia;

    Grafo(){
        this->numeroArestas = 0;
        this->listaListasAdjacencia = *new Lista<Lista<char>>;
    }
    Lista<char>* getListaAdj(char aresta){
        if(existe(aresta)){
            Item<Lista<char>>* ultimo = listaListasAdjacencia.cabeca;
            while (ultimo->proximo != nullptr){
                if(ultimo->dado.cabeca->dado == aresta)
                    return &ultimo->dado;
                ultimo = ultimo->proximo;
            }
        } else
            return nullptr;
    }
    void imprimir(){
        if(listaListasAdjacencia.cabeca != nullptr){
            Item<Lista<char>>* aresta = listaListasAdjacencia.cabeca;
            while (aresta != nullptr){
                std::cout<<aresta->dado.cabeca->dado<<": ";
                Item<char>* adjacencia = aresta->dado.cabeca;
                if (adjacencia->proximo == nullptr)
                    std::cout<<"sem vizinhos";
                else while (adjacencia->proximo != nullptr){
                    std::cout<<adjacencia->dado;
                    adjacencia = adjacencia->proximo;

                    if (adjacencia->proximo == nullptr) std::cout<<"";
                    else std::cout<<",";
                }
                std::cout<<std::endl;
                aresta = aresta->proximo;
            }
        }else{
            std::cout<<"O grafo esta vazio"<<std::endl;
        }
    }
    bool existe(char aresta){
        if(listaListasAdjacencia.cabeca == nullptr) return false;
        Item<Lista<char>>* ultimo = listaListasAdjacencia.cabeca;
        while (ultimo->proximo != nullptr){
            if(ultimo->dado.cabeca->dado == aresta) return true;
            ultimo = ultimo->proximo;
        }
        return false;
    }
    void adicionarAresta(char aresta){
        Item<Lista<char>> * novo = new Item<Lista<char>>;
        novo->dado = *new Lista<char>;
        novo->dado.cabeca = new Item<char>;
        novo->dado.cabeca->dado = aresta;
        if(listaListasAdjacencia.cabeca == nullptr) listaListasAdjacencia.cabeca = novo;
        else{
            Item<Lista<char>>* ultimo = listaListasAdjacencia.cabeca;
            while (ultimo->proximo != nullptr) ultimo = ultimo->proximo;
            ultimo->proximo = novo;
        }
        numeroArestas ++;
        std::cout<<"Adicionado aresta:"<<aresta<<std::endl;
    }
    void removerAresta(char aresta){
        numeroArestas --;
    }
    void AdicionaVizinho(char arestaA, char arestaB){
        bool existeA = existe(arestaA), existeB = existe(arestaB);
        if (existeA && existeB){
            if(arestaA == arestaB){
                Item<char> *ptrLista = getListaAdj(arestaA)->ultimo();
                ptrLista->proximo = new Item<char>(arestaB);
            }else {
                Item<char> *ptrListaA = getListaAdj(arestaA)->ultimo();
                Item<char> *ptrListaB = getListaAdj(arestaB)->ultimo();
                ptrListaA->proximo = new Item<char>(arestaB);
                ptrListaB->proximo = new Item<char>(arestaA);
            }
        }else{
            std::cout<<"Não é possível, uma das arestas ou as duas não existem "<<std::endl;
        }
    }
    Lista<char>* vizinhos(char aresta){
        return new Lista<char>();
    }
    bool TesteVizinhaca(char arestaA,char arestaB){
        return false;
    }

};

int main() {
    Grafo* grafo = new Grafo;
    grafo->adicionarAresta('A');
    grafo->adicionarAresta('B');
    grafo->adicionarAresta('C');
    //grafo->AdicionaVizinho('A', 'B');
    //grafo->AdicionaVizinho('A', 'A');
    grafo->AdicionaVizinho('C', 'C');
    grafo->imprimir();
}