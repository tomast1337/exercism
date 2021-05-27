#include <iostream>
#include <string>
#define ESPACO '='
// Complexidade: O(n log n) onde n é a cadeia
void proximoArranjo(std::string cadeia, int ultimoVazio) {
    if (cadeia[ultimoVazio + 1] != '\0' && cadeia[ultimoVazio + 1] != ESPACO) {
        std::swap(cadeia[ultimoVazio + 1],cadeia[ultimoVazio]);
        std::cout << cadeia << std::endl;
        ultimoVazio++;
        proximoArranjo(cadeia, ultimoVazio);
    } else {
        if (cadeia[ultimoVazio + 1] == '\0') {
            int j ,tamanho = 1;
            while (cadeia[ultimoVazio - tamanho] == ESPACO) tamanho++;
            j = ultimoVazio - tamanho;
            while (cadeia[j] != ESPACO)
                if (j == 0) return;
                else j--;
            int pos = j + 2;

            std::swap(cadeia[j + 1],cadeia[j]);

            std::string fim(cadeia.substr(pos, cadeia.size() - tamanho - pos));
            std::string bloco(cadeia.substr(cadeia.size() - tamanho, tamanho));
            cadeia.erase(pos, cadeia.size() - pos);
            cadeia = cadeia.append(bloco + fim);

            std::cout << cadeia << std::endl;
            proximoArranjo(cadeia, j + 1 + tamanho);
        } else return;
    }
}
// Complexidade O(n log n) onde n é o tamanho do conjunto menor mais os espaços vazios 
void aranjoEspacos( std::string cadeiaA, std::string cadeiaB){
    if (cadeiaA.size() < cadeiaB.size()) std::swap(cadeiaA,cadeiaB);
    std::cout << "Maior Cadeia: " << cadeiaA << std::endl << "Menor Cadeia: " << cadeiaB << std::endl << "Arranjos das maneiras de inserir espaço em branco:" << std::endl;
    int diferenca = cadeiaA.size() - cadeiaB.size();
    std::string vazios(diferenca, ESPACO);
    std::string cadeiaComVazios = vazios + cadeiaB;
    std::cout << cadeiaComVazios << std::endl;
    proximoArranjo(cadeiaComVazios, diferenca - 1);
}
// Complexidade: a função não tem entrada
int main() {
    std::string cadeiaA = "ATAGCTCGT";
    std::string cadeiaB = "ACGCACATACTTGT";
    aranjoEspacos(cadeiaA,cadeiaB);
}