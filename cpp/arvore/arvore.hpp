#include <iostream>
#include <random>
#define TABSIZE 1
typedef struct No *NoPtr;
struct No
{
    int valor;
    NoPtr esquerda;
    NoPtr direita;
    No(int valor, NoPtr esquerda, NoPtr direita)
    {
        this->valor = valor;
        this->esquerda = esquerda;
        this->direita = direita;
    }
    No(int valor)
    {
        this->valor = valor;
        this->esquerda = nullptr;
        this->direita = nullptr;
    }
    No() {}
};

void ImprimirNo(NoPtr no)
{
    std::cout << "End No*:" << no << ", Valor:" << no->valor << ", End Esquerda*:" << no->esquerda << ", End Direita*:" << no->direita << "\n";
}

void ImprimirNosDeGrau1(NoPtr raiz)
{
    if (raiz == nullptr)
    {
        return;
    }
    if ((raiz->esquerda == nullptr) != (raiz->direita == nullptr))
        std::cout << "Nô: " << raiz->valor << " tem grau 1, ";
    if (raiz->esquerda != nullptr)
        ImprimirNosDeGrau1(raiz->esquerda);
    if (raiz->direita != nullptr)
        ImprimirNosDeGrau1(raiz->direita);
}

void ImprimirArvore(NoPtr raiz, int espaco = 0)
{
    if (raiz != NULL)
    {
        espaco += TABSIZE;
        ImprimirArvore(raiz->direita, espaco);
        for (int i = TABSIZE; i < espaco; i++)
            std::cout << "\t";
        std::cout << raiz->valor << "\n";
        ImprimirArvore(raiz->esquerda, espaco);
    }
}

bool is_BinariaDeBusca(NoPtr raiz,int minimo=-2147483648,int maximo =2147483647){
    if (raiz == nullptr)
        return true;
    if(raiz->valor < minimo || raiz->valor > maximo)
        return  false;
    return is_BinariaDeBusca(raiz->esquerda, minimo, raiz->valor-1) && is_BinariaDeBusca(raiz->direita, raiz->valor+1, maximo);
}

int SomarArvore(NoPtr raiz)
{
    if (raiz == nullptr)
        return 0;
    return raiz->valor + ((raiz->esquerda != nullptr) ? SomarArvore(raiz->esquerda) : 0) + ((raiz->direita != nullptr) ? SomarArvore(raiz->direita) : 0);
}

int SomaFolhas(NoPtr raiz)
{
    if (raiz == nullptr)
        return 0;
    if (raiz->direita == nullptr && raiz->esquerda == nullptr)
        return raiz->valor;
    else
        return SomaFolhas(raiz->esquerda) + SomaFolhas(raiz->direita);
}

void PopularArvoreCompleto(NoPtr raiz, int MaxValor, int MinValor, int profundidade)
{
    std::random_device myRandomDevice;
    unsigned seed = myRandomDevice();
    std::default_random_engine myRandomEngine(seed);

    if (profundidade == 0)
        return;
    else
    {
        raiz->valor = myRandomEngine() % MaxValor + 2;
        raiz->esquerda = new No();
        raiz->direita = new No();
        PopularArvoreCompleto(raiz->esquerda, MaxValor, MinValor, profundidade - 1);
        PopularArvoreCompleto(raiz->direita, MaxValor, MinValor, profundidade - 1);
    }
}

void PopularArvoreIncompleto(NoPtr raiz, int MaxValor, int MinValor, int profundidade)
{
    std::random_device myRandomDevice;
    unsigned seed = myRandomDevice();
    std::default_random_engine myRandomEngine(seed);

    if (profundidade == 0)
        return;
    else
    {
        raiz->valor = myRandomEngine() % MaxValor + 2;
        if (myRandomEngine() % 2 == 1)
        {
            raiz->esquerda = new No();
            PopularArvoreIncompleto(raiz->esquerda, MaxValor, MinValor, profundidade - 1);
        }
        if (myRandomEngine() % 2 == 1)
        {
            raiz->direita = new No();
            PopularArvoreIncompleto(raiz->direita, MaxValor, MinValor, profundidade - 1);
        }
    }
}

bool EstritamenteBinaria(NoPtr arvore){
    if(arvore == nullptr)
        return false;
    else // se possui 2 filhos e todos os filhos tambem possuem 2 filhos
        return (arvore->esquerda != nullptr && arvore->direita != nullptr) && (estritamenteBinaria(arvore->direita) && estritamenteBinaria(arvore->esquerda));
}