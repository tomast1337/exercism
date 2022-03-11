#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void swap(void *a, void *b, size_t size){
    void *tmp = malloc(size);
    memcpy(tmp, a, size);
    memcpy(a, b, size);
    memcpy(b, tmp, size);
    free(tmp);
}

void print_arr(char arr[],int size){
    for (int i = 0 ; i < size ; i++){
        printf("%c",arr[i]);
    }
    printf(", ");
}

void heap_p(char arr[],int size,int k){
    if (size == 1) {
        print_arr(arr,k);
        return;
    }
    for (int i = 0 ; i < size ; i++){
        heap_p(arr,size-1,k);
        if (size % 2 == 1){
            swap( (void *)&arr[0], (void *)&arr[size-1], sizeof(char));
        }
        else{
            swap( (void *)&arr[i], (void *)&arr[size-1], sizeof(char));
        }
    }
}

int main(){
    char arr[] = {'1','2','3','4','5'};
    int size = sizeof(arr)/sizeof(arr[0]);
    print_arr(arr,size);
    heap_p(arr,size,size);
    return 0;
}
