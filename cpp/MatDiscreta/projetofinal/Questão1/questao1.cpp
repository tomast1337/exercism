#include <iostream>
struct Cadeia {
    char *cadeia;
    int tamanho;
    Cadeia(char *cadeia, int tamanho) {
        this->cadeia = cadeia;
        this->tamanho = tamanho;
    }
};
void permutar(char *mascara, int tamanho, int n, Cadeia* cadeia) {
    if (tamanho == 1) {
        int iCadeia = 0;
        for (int i = 0; i < n; i++){
            if(mascara[i] == '#'){
                std::cout << cadeia->cadeia[iCadeia];
                iCadeia++;
            }else
                std::cout << "-";
        }
        printf("\n");
        return;
    }
    for (int i = 0; i < tamanho; i++) {
        permutar(mascara, tamanho - 1, n, cadeia);
        if (tamanho % 2 == 1){
            char aux = mascara[0];
            mascara[0] = mascara[tamanho - 1];
            mascara[tamanho - 1] = aux;
        }
        else {
            char aux = mascara[i];
            mascara[i] = mascara[tamanho - 1];
            mascara[tamanho - 1] = aux;
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
    char *mascara = new char[cadeiaA->tamanho];
    for (int i = 0; i < cadeiaA->tamanho; i++) mascara[i] = i >= cadeiaB->tamanho ? '-' : '#';
    std::cout<<"Permutação de maneiras de inserir espaço em branco:"<<std::endl;
    permutar(mascara, cadeiaA->tamanho, cadeiaA->tamanho, cadeiaB);
}
int main() {
    Cadeia *cadeiaA = new Cadeia("GCTA", 4);
    Cadeia *cadeiaB = new Cadeia("AG", 2);
    percorrer(cadeiaB, cadeiaA);
}