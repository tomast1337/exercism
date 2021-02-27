void SelectionSort(int* array,int tamanho){
    for (int i = 0; i < tamanho; ++i) {
        int iMenor = i;
        for (int j = i+1; j < tamanho; ++j) {
            if (array[j] < array[iMenor]) {
                iMenor = j;
            }
        }
        int aux = array[i];
        array[i] = array[iMenor];
        array[iMenor] = aux;
    }
}