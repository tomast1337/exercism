#include "BubbleSort.h"
#include "CountingSort.h"
#include "RadixSort.h"
#include "MergeSort.h"
#include "InsertionSort.h"
#include "SelectionSort.h"

#include <iostream>
#include <chrono>
#include <stdlib.h>

void printArray(int* array,int tamanho){
    std::cout<<"[";
    for(int i=0; i<tamanho; i++)
        std::cout<<array[i]<<",";
    std::cout<<"]";
}

template<typename F>
void Test(F func,int array[],int size){;    
    int sort[size];
    for(int i = 0;i <size;i++){ // Copy from reference
        sort[i] = array[i];
    }

    std::chrono::steady_clock::time_point start;
    std::chrono::steady_clock::time_point end;

    start = std::chrono::steady_clock::now();
    
    std::cout<<"\tEntrada:\t ";
    printArray(array,size);

    func(sort,size);

    std::cout<<"\n\tSaida:\t\t ";
    printArray(sort,size);
    
    end = std::chrono::steady_clock::now();
    std::cout<<"\n\tTempo Execução:\t\t "<< std::chrono::duration_cast<std::chrono::microseconds>(end - start).count() << " [microssegundos]" << std::endl;
}

int main(){
    int size;

    std::cout<<"Digite o tamnho da array a ser testada:";
    std::cin>>size;
    
    int array[size];

    for (auto i=0; i < size; i++){
        array[i] = rand() % 100 + 1;
    }
    
    
    
    std::cout<<"\n\t\t\t\tBubbleSort\n";
    Test(BubbleSort,array,size);
    
    std::cout<<"\n\t\t\t\tMergeSort\n";
    Test(MergeSort,array,size);

    std::cout<<"\n\t\t\t\tInsertionSort\n";
    Test(InsertionSort,array,size);
    
    std::cout<<"\n\t\t\t\tSelectionSort\n";
    Test(SelectionSort,array,size);

    std::cout<<"\n\t\t\t\tCountingSort\n";
    Test(CountingSort,array,size);
    
    std::cout<<"\n\t\t\t\tRadixSort\n";
    Test(RadixSort,array,size);
    std::cout<<"\n\t\tTodos os algoritimos agiram sobre a um referencia a array\n";
}