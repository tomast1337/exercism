#include <stdio.h>
#include <stdlib.h>
// point struct 
typedef struct {
    int x;
    int y;
} Point; 

void* retorna_qualquer(int x){
    char* a = "String";
    
    int* b = malloc(sizeof(int));
    *b = 10;
    
    float* c = malloc(sizeof(float));
    *c = 3.14f;
    
    double* d = malloc(sizeof(double));
    *d = 3.141592653589793238462643383;
    
    long* e = malloc(sizeof(long));
    *e = 3;
    
    Point* f = malloc(sizeof(Point));
    f->x = 1;
    f->y = 2;

    if(x == 1) // return a
        return a;
    if(x == 2) // return b
        return b;
    if(x == 3) // return c
        return c;
    if(x == 4) // return d
        return d;
    if(x == 5) // return e
        return e;
    if(x == 6) // return f
        return f;
    return malloc(sizeof(int));
} 

int main(){
    Point* a = retorna_qualquer(1);
    Point* b = retorna_qualquer(2);
    Point* c = retorna_qualquer(3);
    Point* d = retorna_qualquer(4);
    Point* e = retorna_qualquer(5);
    Point* f = retorna_qualquer(1);

    printf("%d %d\n", a->x, a->y);
    printf("%d %d\n", b->x, b->y);
    printf("%d %d\n", c->x, c->y);
    printf("%d %d\n", d->x, d->y);
    printf("%d %d\n", e->x, e->y);
    printf("%d %d\n", f->x, f->y);
}


