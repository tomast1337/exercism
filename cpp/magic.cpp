#include <iostream>
void insetionSort(char array[],int tamanho){
    for (int i = 1,j; i < tamanho; i++) {
        char chave = array[i];
        for (j = i - 1; j >= 0 && array[j] > chave; j--)
            array[j + 1] = array[j];
        array[j + 1] = chave;
    }
}

int main(){
    char valores[] = "NicolasAmaLetica";
    std::cout<<valores<<std::endl;
    insetionSort(valores,16);
    std::cout<<valores<<std::endl;;

    return 0;
}