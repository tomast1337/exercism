#include <iostream>

void Merge(int array[], int inicio, int meio, int fim,int arrayAux[]){
    int dir_i = inicio;
    int esq_i = meio;
    for(int i = inicio; i < fim; i++){
        if( (esq_i < meio)&& ((dir_i >= fim) || array[esq_i] < array[dir_i])){
            arrayAux[i] = array[esq_i];
            esq_i++;
        }else{
            arrayAux[i] = array[dir_i];
            dir_i++;
        }
    }
    for (int i = inicio; i < fim; ++i) {
        array[i] = arrayAux[i];
    }
}
void Sort(int array[],int inicio,int fim,int arrayAux[]){
    if(inicio>=fim) return;
   
    int meio = (inicio+fim)/2;
    Sort(array,inicio,meio,arrayAux);
    Sort(array,meio+1,fim,arrayAux);
    Merge(array,inicio,meio,fim,arrayAux);
}

void MergeSort(int array[],int tamanho){
    int arrayAux[tamanho];
    Sort(array, 0, tamanho,arrayAux);
}