#include <iostream>
using namespace std;

float mediaValoresVetor(float vet[], int tamanho)
{
    float soma = 0;

    for (int i = 0; i < tamanho; i++)
    {
        soma = soma + vet[i];
    }
    return soma / tamanho;
}

int main()
{
    int i, tam;
    cout << "Qual o tamanho do vetor? ";
    cin >> tam;
    float vet[tam];
    cout << "Digite " << tam << " valores:\n";
    for (i = 0; i < tam; i++)
    {
        cin >> vet[i];
    }
    cout << "Media: " << mediaValoresVetor(vet, tam) << endl;
    return 0;
}
