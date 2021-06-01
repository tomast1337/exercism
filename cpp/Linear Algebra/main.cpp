#include <thread>
#include <iostream>
#include <string>

void multiplicacao(int *matrizX, int *matrizY, int *matrizZ, int tam, int core, int thread) {
    // Cada thread faz uma % da operação. (varia de acordo com a quantidade de threads totais)
    for (int i = core * tam / thread; i < (core + 1) * tam / thread; i++)
        for (int j = 0; j < tam; j++) {
            matrizZ[tam * i + j] = 0;
            std::string operacao = "matrizZ[" + std::to_string(i + 1) + "," + std::to_string(j + 1) + "] =";
            for (int k = 0; k < tam; k++) {
                operacao +=
                        "+(" + std::to_string(matrizX[tam * i + k]) + "*" +std::to_string(matrizY[tam * j + k]) + ")";
                matrizZ[tam * i + j] += matrizX[tam * i + k] * matrizY[tam * j + k];
            }
            operacao += " = " + std::to_string(matrizZ[tam * i + j]) + "\n";
            std::cout << operacao;
        }
}

void imprimirMatriz(char *nome, int *matrix, int tam) {
    std::cout << nome << std::endl;
    for (int i = 0; i < tam; i++) {
        for (int j = 0; j < tam; j++) {
            std::cout << matrix[tam * i + j];
            if (j == tam - 1) std::cout << " ";
            else std::cout << "\t";
        }
        std::cout << std::endl;
    }
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        std::cout << "Argumentos insuficientes!!\n\n";
        return 0;
    }
    int num_threads = strtol(argv[1], nullptr, 10);
    int tam = strtol(argv[2], nullptr, 10);

    int *matrizX = new int[tam * tam];
    int *matrizY = new int[tam * tam];
    int *matrizZ = new int[tam * tam];

    //srand(time(0));
    // gerando valores aleatórios para matriz X,Y
    for (int i = 0; i < tam * tam; i++) {
        matrizX[i] = (rand() % 10) + 1;
        matrizY[i] = (rand() % 10) + 1;
    }
    std::thread threads[num_threads];
    // Criando threads e definindo os processos
    for (int i = 0; i < num_threads; i++)
        threads[i] = std::thread(multiplicacao, matrizX, matrizY, matrizZ, tam, i, num_threads);
    // Esperando as threads concluirem os processos
    for (int i = 0; i < num_threads; i++) threads[i].join();
    //multiplicacao_norma(matrizX,matrizY,matrizZ,tam);

    std::cout << "Entrada:\n";
    imprimirMatriz("Matriz X", matrizX, tam);
    imprimirMatriz("Matriz Y", matrizY, tam);
    std::cout << "\nSaida:\nUtilizando " << num_threads
              << " threads, o resultado da multiplicação da matriz X com a matriz Y é: \n";
    imprimirMatriz("Matriz Z", matrizZ, tam);
    return 0;
}