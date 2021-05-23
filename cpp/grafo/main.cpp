#include <iostream>

template<typename Struct>
struct Item {
    Struct dado;
    Item *proximo;

    Item() {}

    Item(Struct dado) {
        this->dado = dado;
    }

    Item(Struct dado, Item *proximo) {
        this->proximo = proximo;
        this->dado = dado;
    }
};

template<typename Struct>
struct Lista {
    Item<Struct> *cabeca;

    void remover(Item<Struct> *item) {
        if (item == cabeca) {
            Item<Struct> *antigo = cabeca;
            cabeca = cabeca->proximo == nullptr ? cabeca = nullptr : cabeca->proximo;;
            delete antigo;
        } else {
            Item<Struct> *anterior = cabeca;
            while (anterior->proximo != nullptr && anterior->proximo != item) {
                anterior = anterior->proximo;
            }
            if (anterior->proximo != nullptr) {
                anterior->proximo = anterior->proximo->proximo;
                delete item;
            }
        }
    }

    void inserir(Item<Struct> *item) {
        if (cabeca == nullptr) {
            cabeca = item;
        } else {
            Item<Struct> *ulitmo = cabeca;
            while (ulitmo->proximo != nullptr) {
                ulitmo = ulitmo->proximo;
            }
            ulitmo->proximo = item;
        }
    }

    Item<Struct> *ultimo() {
        Item<Struct> *ultimo = cabeca;
        while (ultimo->proximo != nullptr)
            ultimo = ultimo->proximo;
        return ultimo;
    }
};

struct Grafo {
    int numeroVertices;
    Lista<Lista<char>> listaListasAdjacencia;

    Grafo() {
        this->numeroVertices = 0;
        this->listaListasAdjacencia = *new Lista<Lista<char>>;
    }

    Item<Lista<char>> *getLista(char vertice) {
        if (existe(vertice)) {
            Item<Lista<char>> *ultimo = listaListasAdjacencia.cabeca;
            while (ultimo != nullptr) {
                if (ultimo->dado.cabeca->dado == vertice)
                    return ultimo;
                ultimo = ultimo->proximo;
            }
        } else
            return nullptr;
    }

    Lista<char> *getVizinhos(char vertice) {
        if (existe(vertice)) {
            Item<Lista<char>> *ultimo = listaListasAdjacencia.cabeca;
            while (ultimo->proximo != nullptr) {
                if (ultimo->dado.cabeca->dado == vertice)
                    return &ultimo->dado;
                ultimo = ultimo->proximo;
            }
        } else
            return nullptr;
    }

    void imprimirAdjacencia(char vertice) {
        if (existe(vertice)) {
            Item<Lista<char>>* listaVerice = getLista(vertice);
            if(listaVerice->proximo == nullptr){
                std::cout <<vertice<<": sem vizinhos";
            } else {
                Item<char> *vizinho = getVizinhos(vertice)->cabeca;
                std::cout << vizinho->dado << ": ";
                vizinho = vizinho->proximo;
                while (vizinho != nullptr) {
                    std::cout << vizinho->dado;
                    vizinho = vizinho->proximo;
                    if (vizinho == nullptr) std::cout << "";
                    else std::cout << ",";
                }
            }
        } else
            std::cout << "Vértice " << vertice << " não existe";
    }

    void imprimirGrafo() {
        std::cout << "Imprimindo grafo" << std::endl;
        if (listaListasAdjacencia.cabeca != nullptr) {
            Item<Lista<char>> *vertice = listaListasAdjacencia.cabeca;
            while (vertice != nullptr) {
                imprimirAdjacencia(vertice->dado.cabeca->dado);
                std::cout << std::endl;
                vertice = vertice->proximo;
            }
            std::cout << "Total vertices: " << numeroVertices << std::endl;
        } else {
            std::cout << "O grafo esta vazio" << std::endl;
        }
    }

    bool existe(char vertice) {
        Item<Lista<char>> *proximo = listaListasAdjacencia.cabeca;
        while (proximo != nullptr) {
            if (proximo->dado.cabeca->dado == vertice) return true;
            proximo = proximo->proximo;
        }
        return false;
    }

    void adicionarVertice(char vertice) {
        if (!existe(vertice)) {
            Item<Lista<char>> *novo = new Item<Lista<char>>;
            novo->dado = *new Lista<char>;
            novo->dado.inserir(new Item<char>(vertice));
            if (listaListasAdjacencia.cabeca == nullptr) listaListasAdjacencia.cabeca = novo;
            else {
                Item<Lista<char>> *ultimo = listaListasAdjacencia.ultimo();
                ultimo->proximo = novo;
            }
            numeroVertices++;
            std::cout << "Adicionado vértice:" << vertice << std::endl;
        } else {
            std::cout << "Vértice:" << vertice << " já existe, não pode ser adicionado" << std::endl;
        }

    }

    void removerVertice(char vertice) {
        if (existe(vertice)) {
            Item<Lista<char>> *listaVertice = getLista(vertice);
            listaListasAdjacencia.remover(listaVertice);
            numeroVertices--;
            std::cout << "Removido vértice:" << vertice << std::endl;
        } else {
            std::cout << "Vértice:" << vertice << " não existe, não pode ser removido" << std::endl;
        }
    }

    void AdicionaVizinhaca(char verticeA, char verticeB) {
        bool existeA = existe(verticeA), existeB = existe(verticeB);
        if (existeA && existeB) {
            if (verticeA == verticeB) {
                getLista(verticeA)->dado.inserir(new Item<char>(verticeB));
                std::cout << verticeA << " é vizinho de " << verticeB << std::endl;
            } else {
                getLista(verticeB)->dado.inserir(new Item<char>(verticeA));
                getLista(verticeA)->dado.inserir(new Item<char>(verticeB));
                std::cout << verticeA << " e " << verticeB << " são vizinhos" << std::endl;
            }
        } else {
            std::cout << "Não é possível, um dos vertices ou as duas não existem " << std::endl;
        }
    }

    void removerVizinhaca(){

    }

    bool TesteVizinhaca(char verticeA, char verticeB) {
    }
};

int main() {
    Grafo *grafo = new Grafo;

    grafo->adicionarVertice('E');
    grafo->imprimirGrafo();


    grafo->adicionarVertice('A');
    grafo->adicionarVertice('B');
    grafo->adicionarVertice('C');
    grafo->adicionarVertice('D');

    std::cout << std::endl;
    grafo->AdicionaVizinhaca('B', 'A');
    grafo->AdicionaVizinhaca('C', 'D');
    grafo->AdicionaVizinhaca('A', 'A');
    grafo->AdicionaVizinhaca('C', 'C');

    std::cout << std::endl;
    grafo->imprimirGrafo();

    std::cout << std::endl;
    grafo->adicionarVertice('G');
    grafo->adicionarVertice('H');
    grafo->adicionarVertice('K');

    std::cout << std::endl;
    grafo->AdicionaVizinhaca('G', 'A');
    grafo->AdicionaVizinhaca('G', 'B');
    grafo->AdicionaVizinhaca('G', 'D');
    grafo->AdicionaVizinhaca('G', 'E');
    grafo->AdicionaVizinhaca('H', 'H');

    std::cout << std::endl;
    grafo->imprimirGrafo();

    std::cout << std::endl;
}