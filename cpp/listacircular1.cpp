#include <iostream>

using namespace std;

typedef struct no
{
    int info;
    struct no *prox;
} No;

typedef No *noPtr;

typedef struct listacircular
{
    noPtr primeiro;
    noPtr ultimo;
    int tamanho;
} ListaCircular;

typedef ListaCircular *listaCircularPtr;

void listar(listaCircularPtr lista)
{
    noPtr aux = lista->primeiro;
    if (aux != NULL)
    {
        cout << "...👉";
        do
        {
            cout << aux->info << "👉";
            aux = aux->prox;
        } while (aux != lista->primeiro);
        cout << "..."<< endl;
    }
    else
    {
        cout << "lista vazia 🥺.\n";
    }
}

void inserirFinal(int valor, listaCircularPtr lista)
{
    noPtr novo = new No;
    novo->info = valor;
    novo->prox = lista->primeiro;
    if (lista->primeiro == NULL)
    {
        lista->primeiro = novo;
        lista->ultimo = novo;
    }
    else
    {
        lista->ultimo->prox = novo;
        lista->ultimo = novo;
    }
    cout << "🥳 " << valor << " inserido no final com sucesso.\n";
    
}

void inserirInicio(int valor, listaCircularPtr lista)
{
    noPtr novoInicio = new No;
    novoInicio->info = valor;
    if (lista->primeiro == NULL)
    {
        novoInicio->prox = novoInicio;
        lista->primeiro = novoInicio;
        lista->ultimo = novoInicio;
    }
    else
    {
        novoInicio->prox = lista->primeiro;
        lista->primeiro = novoInicio; 
        lista->ultimo->prox = lista->primeiro; // Altera o proximo do ultimo para o novo inicio.
    }
    cout << "🥳 " << valor << " inserido no começo com sucesso.\n";
}

void popInicio(listaCircularPtr lista)
{
    if (lista->primeiro != NULL)
    {
        noPtr aux = lista->primeiro;
        lista->primeiro = lista->primeiro->prox;
        lista->ultimo->prox = lista->primeiro;
        cout << "🧹 " << aux->info << " removido do inicio com sucesso.\n";
        delete aux;
    }
    else
    {
        cout << "lista vazia 🥺.\n";
    }
}

void popFim(listaCircularPtr lista){
    if (lista->primeiro != NULL)
    {
        noPtr penúltimo = lista->primeiro;
        while (penúltimo->prox->prox != lista->primeiro)
        {
            penúltimo = penúltimo->prox;
        }
        penúltimo->prox = lista->primeiro;
        cout << "🧼 " << lista->ultimo->info << " removido do fim com sucesso.\n";
        delete lista->ultimo;
        lista->ultimo = penúltimo;
    }
    else
    {
        cout << "lista vazia 🥺.\n";
    }
}

int remover(int valor, listaCircularPtr lista){
    if (lista->primeiro != NULL)
    {
        noPtr aux = lista->primeiro;
        while (aux->prox != lista->primeiro && aux->info != valor) // Encontra o No a ser removido ou o primeiro se não encontrar.
        {
            aux = aux->prox;
        }
        if (aux->info == valor) // Se for o valor procurado remover ele
        {
            if (aux == lista->primeiro) // Se o valor é o primeiro
            {
                popInicio(lista);
            }
            else if (aux == lista->ultimo) // se o valor é o ultimo
            {
                popFim(lista);
            }
            else // Se não for o primeiro nem o ultimo
            {
                noPtr aux2 = aux->prox;
                aux->prox = aux2->prox;
                cout << "❌ " << valor << " removido com sucesso.\n";
                delete aux2;
            }
        }
        else
        {
            cout << "👎🏿 " << valor << " não encontrado.\n";
        }
    }
    else
    {
        cout << "lista vazia 🥺.\n";
    }
}

int main()
{
    listaCircularPtr lista = new ListaCircular;
    for (int i = 0; i < 15; i++) inserirFinal((i%10), lista);
    listar(lista);
    for (int i = 0; i > -10; i--) inserirInicio((i%10), lista);
    listar(lista);
    for (int i = 0; i < 5; i++) popInicio(lista);
    listar(lista);
    for (int i = 0; i > -5; i--) popFim(lista);
    listar(lista);
    remover(0,lista);
    return EXIT_SUCCESS;
}
