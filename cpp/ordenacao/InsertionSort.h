void InsertionSort(int array[],int tamanho){
    for (int i = 1,inserir, j; i < tamanho; i++) {
        inserir = array[i];
        j = i - 1;
        while (j >= 0 && array[j] > inserir) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = inserir;
    }
}