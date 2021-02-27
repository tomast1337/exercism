#include <iostream>

int* BubbleSort(int array[],int tamanho){
    int swap;
    for(int i=0; i<tamanho-1; i++){
        for(int j= i+1; j<tamanho; j++){
            if(array[i] > array[j]){
                swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }
    }
    return array;
}

void printArray(int* array,int tamanho){
    std::cout<<"[";
    for(int i=0; i<tamanho; i++)
        std::cout<<array[i]<<",";
    std::cout<<"]";
}

int main(){
    int nums[10] = {1,5,9,8,7,10,6,3,2,4};
    int size = sizeof(nums)/sizeof(nums[0]);
    
    std::cout<<"\n\n\n\tEntrada:\t ";
    printArray(nums,size);
    
    int* sort = BubbleSort(nums,size);
    
    std::cout<<"\n\tSaida:\t\t ";
    printArray(sort,size);
    std::cout<<"\n\n\n";
}