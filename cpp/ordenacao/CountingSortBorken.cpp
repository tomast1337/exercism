#include <iostream>

void printArray(int* array,int tamanho){
    std::cout<<"[";
    for(int i=0; i<tamanho; i++)
        std::cout<<array[i]<<",";
    std::cout<<"]";
}

int* CountingSort(int array[],int tamanho){
    int maior = array[0];
    for(int i=0; i<tamanho; i++) // Achar maior valor na array
        if(array[i] > maior)
            maior = array[i];

    int counter[maior] = { 0 }; // Uma das desvantagem desse algoritimo é que ele pode ultilisar muita memoraia se o maior numero for muito grande
    
    for (int i = 0; i < tamanho; i++) // Conto quantas vezes cada numero aparece
        counter[array[i]]++; 
    
    for (int i = 1; i < 10; i++) 
        counter[i] += counter[i - 1]; 

    int* saida = new int[tamanho];     
    for (int i = tamanho-1; i >= 0; i--) { // Montando a variavel de saida 
        saida[counter[array[i]] - 1] = array[i]; 
        counter[array[i]]--; 
    }

    return saida;
}


int main(){
    int nums[] = {1,5,9,8,7,10,6,3,2,4,5,8,7,4,0,0,8,9,5,4,10,0,0,2,3,6,5,4,7,8,9,5,1,2,10,3,5};// numeros de 0 a 10
    int size = sizeof(nums)/sizeof(nums[0]);
    
    std::cout<<"\n\n\n\tEntrada:\t ";
    printArray(nums,size);
    
    int* sort = CountingSort(nums,size);
    
    std::cout<<"\n\tSaida:\t\t ";
    printArray(sort,size);
    std::cout<<"\n\n\n";
}