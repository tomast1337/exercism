void BubbleSort(int array[],int tamanho){
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
}