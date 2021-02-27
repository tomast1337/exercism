void RadixSort(int array[],int tamanho){
    int maior = array[0];
    for(int i=0; i<tamanho; i++)// Achar maior valor na array
        if(array[i] > maior)
            maior = array[i];

    for (int expoente = 1; maior / expoente > 0; expoente *= 10){ // Ordena os numero pelas casas da unidade, dezena, centena ...
        // Essa verção do counting sort organiza os numero de 0 a 9 resolvendo parcealmente o probelma do outro de precisar alocar muita memoria
        int passo[tamanho]; 
        int counter[10] = { 0 }; 
    
        for (int i = 0; i < tamanho; i++) 
            counter[ (array[i]/expoente)%10 ]++; 
    
        for (int i = 1; i < 10; i++) 
          counter[i] += counter[i - 1]; 
    
        for (int i = tamanho - 1; i >= 0; i--) { 
            passo[counter[ (array[i]/expoente)%10 ] - 1] = array[i]; 
            counter[ (array[i]/expoente)%10 ]--; 
        }
        for (int i = 0; i < tamanho; i++) 
            array[i] = passo[i]; 
    }
}