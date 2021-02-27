void CountingSort(int array[],int tamanho){
    int maior = array[0];
    for(int i=0; i<tamanho; i++)// Achar maior valor na array
        if(array[i] > maior)
            maior = array[i];

    int counter[maior+1] = { 0 }; // Desvantagem do algotimo é que ele usa muita memoria se o maior numero for 1 bilhão usaria 1 bilhão de endereços 
    for(int i=0; i<tamanho; i++)  // Conto quantas vezes cada numero aparece na array
        counter[array[i]] ++;

    int offset = 0;
    for(int i = 0; i < maior+1; i++){// Adiciono os numero organizados na nova array saida
        for(int j=0; j<counter[i]; j++){
            array[offset] = i;
            offset++;
        }
    }

}