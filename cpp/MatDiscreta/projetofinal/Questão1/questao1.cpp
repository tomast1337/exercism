#include <iostream>

struct Cadeia {
    char *cadeia;
    int tamanho;

    Cadeia(char *cadeia, int tamanho) {
        this->cadeia = cadeia;
        this->tamanho = tamanho;
    }
};

void permutar(Cadeia *mascara, int tamanho, int n, Cadeia *cadeia) {
    if (tamanho == 1) {
        for (int i = 0,iCadeia = 0; i < n; i++) {
            if (mascara->cadeia[i] == '#') {
                std::cout << cadeia->cadeia[iCadeia];
                iCadeia++;
            } else
                std::cout << "-";
        }
        std::cout << std::endl;
        return;
    }
    for (int i = 0; i < tamanho; i++) {
        permutar(mascara, tamanho - 1, n, cadeia);
        if (tamanho % 2 == 1 && i < tamanho - 1) {
            char aux = mascara->cadeia[i];
            mascara->cadeia[i] = mascara->cadeia[tamanho - 1];
            mascara->cadeia[tamanho - 1] = aux;
        } else {
            char aux = mascara->cadeia[i];
            mascara->cadeia[i] = mascara->cadeia[tamanho - 1];
            mascara->cadeia[tamanho - 1] = aux;
        }
    }
}

void percorrer(Cadeia *cadeiaA, Cadeia *cadeiaB) {
    if (cadeiaA->tamanho < cadeiaB->tamanho) {
        Cadeia *aux = cadeiaA;
        cadeiaA = cadeiaB;
        cadeiaB = aux;
    }
    std::cout << "Maior Cadeia: " << cadeiaA->cadeia << std::endl;
    std::cout << "Menor Cadeia: " << cadeiaB->cadeia << std::endl;
    Cadeia *mascara = new Cadeia(new char[cadeiaA->tamanho], cadeiaA->tamanho);
    for (int i = 0; i < cadeiaA->tamanho; i++) mascara->cadeia[i] = i >= cadeiaB->tamanho ? '-' : '#';
    std::cout << "Permutação de maneiras de inserir espaço em branco:" << std::endl;
    permutar(mascara, cadeiaA->tamanho, cadeiaA->tamanho, cadeiaB);
}

int main() {
    Cadeia *cadeiaA = new Cadeia("GCTA", 4);
    Cadeia *cadeiaB = new Cadeia("AG", 2);
    percorrer(cadeiaB, cadeiaA);
}