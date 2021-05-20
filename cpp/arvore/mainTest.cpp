#include "arvore.hpp"
#include <iostream>
#define DEEP 2
int main()
{
    std::cout << "Arvore com profundidade " << DEEP << std::endl;
    NoPtr arvore = new No();
    PopularArvoreCompleto(arvore, 10, 1, DEEP);
    ImprimirArvore(arvore);
    std::cout << "Soma dos valores das folhas: " << SomaFolhas(arvore) << std::endl;

    delete arvore;

    std::cout << "Arvore não balanceada" << std::endl;
    arvore = new No();
    PopularArvoreIncompleto(arvore, 10, 1, DEEP);
    std::cout << "Soma dos valores das folhas: " << SomaFolhas(arvore) << std::endl;
    ImprimirArvore(arvore);

    return 0;
}
