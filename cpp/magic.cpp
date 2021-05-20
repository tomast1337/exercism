#include <iostream>
void passarPorValor(int valor){}
void passarPorMagica(){
    int magica;
    std::cout<<"Magica:"<<magica<<std::endl;
}
int main(){
    int valor = 100;
    passarPorValor(valor);
    passarPorMagica();
    return 0;
}