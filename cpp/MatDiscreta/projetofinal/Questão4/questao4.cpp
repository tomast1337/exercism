#include <iostream>
#include <fstream>

//Questão 4

// Estrutura define uma cadeia de acidos nucleicos
struct Cadeia{
    char* cadeia;
    int tamanho;
    // Construtor da estrutura
    Cadeia(char* cadeia,int tamanho){
        this->cadeia = cadeia;
        this->tamanho = tamanho;
    }
    // Método Imprime a Cadeia
    void printCadeia(){
        std::cout<<this->cadeia;
    }
    // Método Inverte a cadeia
    void inverterCadeia(){
        for(int i = 0;i < this->tamanho/2 ;i++){
            char aux = this->cadeia[i];
            this->cadeia[i] = this->cadeia[this->tamanho-1-i];
            this->cadeia[this->tamanho-1-i] = aux;
        }
    }
};
typedef Cadeia* CadeiaPtr;
// limpar a tela
void limparTela(){
    #ifdef WINDOWS
        std::system("cls");
    #else
        std::system ("clear");
    #endif
}
// Função Retorna uma fatia da cadeia partir do index do começo e fim dentro ca cadeia original
CadeiaPtr fatiaCadeia(CadeiaPtr cadeia,int comeco,int fim){
    int tamanho = fim-comeco;
    char* array = new char[tamanho];
    for(int i = comeco;i < fim;i++)
        array[i-comeco] = cadeia->cadeia[i];
    return new Cadeia(array,tamanho);
}

// Retorna se uma cadeia é ou não sub cadeia da de outra
bool buscarSubCadeia(CadeiaPtr cadeia,CadeiaPtr subCadeia){
    if(cadeia->tamanho == subCadeia->tamanho){
        bool igual = true;
        for(int index = 0; index < cadeia->tamanho; index++){
            igual = igual && cadeia->cadeia[index] == subCadeia->cadeia[index];
        }
        return igual;
    }else{
        for(int index = 0; index < cadeia->tamanho-subCadeia->tamanho+1; index++){
            bool achou = true;
            for(int offset = 0;offset < subCadeia->tamanho;offset++)
                achou = cadeia->cadeia[index+offset] == subCadeia->cadeia[offset] && achou; // Verifica se sub Cadeia é igual
            if(achou) return achou; // Retorna na primeira aparição dessa sub cadeia
        }
        return false;
    }
}
//Encontra sub cadeias em comum em duas cadeias de bases nitrogenadas
CadeiaPtr maiorSubCadeiaComum(CadeiaPtr cadeiaA,CadeiaPtr cadeiaB){
    //Solução força bruta
    for(int t = cadeiaA->tamanho; t > 1; t--){ // Controla o tamanho da sub cadeia, buscando do maior caso ao menor
        for(int i = 0; i <= cadeiaB->tamanho - t; i++){ // Anda pela cadeia comparando um pedaço a outra cadeia
            CadeiaPtr subCadeia = fatiaCadeia(cadeiaA,i,i+t);
            if(buscarSubCadeia(cadeiaB,subCadeia))
                return subCadeia;
        }
    }
    return nullptr;// Nem uma sub cadeia encontrada, maior sub cadeia é vazia
}
// Função para o usuário criar uma Cadeia em tempo de execução
CadeiaPtr criarCadeia(){
    int tamanho;
    std::cout<<"Digite o tamanho da cadeia:"<<std::endl;
    std::cin>>tamanho;
    char* cadeia = new char[tamanho];
    for(int i = 0;i < tamanho;i++){
        std::cout<<std::endl<<"Digite o a letra da base nitrogenada n° "<<i+1<<"; A, C, G ou T."<<std::endl;
        char input;
        while(true){
            std::cin>>input;
            if(input >= 'a') input = input - 32;// Converter para Maiúscula
            if(input == 'A' || input == 'C' || input == 'G'|| input == 'T'){
                break;
            }else{
                std::cout<<"Valor invalido tente novamente."<<std::endl;
            }
        }
        cadeia[i] = input;
    }
    return  new Cadeia(cadeia, tamanho);
}
void printCadeiaACadeiaB(CadeiaPtr cadeiaA,CadeiaPtr cadeiaB){
    std::cout<<"Cadeia A: ";
    if(cadeiaA == nullptr) std::cout<<"Cadeia vazia! ";
    else cadeiaA->printCadeia();
    std::cout<<std::endl<<"Cadeia B: ";
    if(cadeiaB == nullptr) std::cout<<"Cadeia vazia! ";
    else cadeiaB->printCadeia();
}
// Menu para o modo de execução 2
void menu(CadeiaPtr cadeiaA,CadeiaPtr cadeiaB){
    int op;
    while(op != 0){
        std::cout<<"1 - Criar ou Recriar a Cadeia A\t2 - Criar ou Recriar a Cadeia B"<<std::endl;
        std::cout<<"3 - Imprimir Cadeias\t\t4 - Achar maior sub cadeia"<<std::endl;
        std::cout<<"0 - Sair do programa"<<std::endl;
        std::cout<<"Digite uma opção:";
        std::cin>>op;

        switch (op) {
            case 1:
                limparTela();
                if(cadeiaA != nullptr) delete cadeiaA;
                cadeiaA = criarCadeia();
                break;
            case 2:
                limparTela();
                if(cadeiaB != nullptr) delete cadeiaB;
                cadeiaB = criarCadeia();
                break;
            case 3:
                limparTela();
                printCadeiaACadeiaB(cadeiaA,cadeiaB);
                std::cout<<std::endl<<std::endl;
                break;
            case 4:
                if(cadeiaA ==nullptr || cadeiaB ==  nullptr){
                    limparTela();
                    std::cout<<"Uma das cadeias esta vazia!!"<<std::endl;
                    printCadeiaACadeiaB(cadeiaA,cadeiaB);
                    std::cout<<std::endl<<std::endl;
                }else{
                    limparTela();
                    printCadeiaACadeiaB(cadeiaA,cadeiaB);
                    CadeiaPtr maiorSub = maiorSubCadeiaComum(cadeiaA,cadeiaB);
                    std::cout<<std::endl<<"A maior sub cadeia é: ";
                    maiorSub->printCadeia();
                    std::cout<<std::endl<<"Com o tamanho: "<<maiorSub->tamanho<<std::endl;
                    
                    cadeiaA->inverterCadeia();
                    maiorSub = maiorSubCadeiaComum(cadeiaA,cadeiaB);
                    std::cout<<"A maior sub cadeia reversa é: ";
                    maiorSub->printCadeia();
                    std::cout<<std::endl<<"Com o tamanho: "<<maiorSub->tamanho<<std::endl<<std::endl;
                }
                break;
            case 0:
                std::cout<<"Saindo .."<<std::endl<<std::endl;
                break;
            default:
                limparTela();
                std::cout<<"Opção invalida! Tente novamente."<<std::endl<<std::endl;
        }
    }


}
// Abre, le e retorna uma CadeiaPtr com a cadeia presente no arquivo
CadeiaPtr ArquivoToCadeia(char* FilePath){
    std::fstream arquivo;
    arquivo.open(FilePath,std::ios::in); // Abre arquivo
    std::filebuf* bufferArquivo = arquivo.rdbuf(); // Cria um buffer para o arquivo

    std::size_t size = bufferArquivo->pubseekoff (0,arquivo.end,arquivo.in); // Tamanho do arquivo
    bufferArquivo->pubseekpos (0,arquivo.in);

    char* cadeia = new char[size];
    bufferArquivo->sgetn (cadeia,size); // Pega dados do arquivo
    arquivo.close();

    return new Cadeia(cadeia,size);
}
// Procura a sub cadeia em dois arquivos, modo de execução 1
void ProcurarEmArquivos(char *argv[],CadeiaPtr cadeiaA,CadeiaPtr cadeiaB){
    limparTela();
    std::cout<<"Abrindo arquivos "<<argv[1]<<" e "<<argv[2]<<std::endl;
    cadeiaA = ArquivoToCadeia(argv[1]);
    cadeiaB = ArquivoToCadeia(argv[2]);
    CadeiaPtr maiorSub = nullptr;

    std::cout<<std::endl<<"Cadeia A possui o tamanho: "<<cadeiaA->tamanho<<std::endl;
    std::cout<<"Cadeia B possui o tamanho: "<<cadeiaB->tamanho<<std::endl;

    maiorSub = maiorSubCadeiaComum(cadeiaA,cadeiaB);
    std::cout<<"A maior sub cadeia é: ";
    maiorSub->printCadeia();
    std::cout<<std::endl<<"Com o tamanho: "<<maiorSub->tamanho<<std::endl;
    
    cadeiaA->inverterCadeia();
    maiorSub = maiorSubCadeiaComum(cadeiaA,cadeiaB);
    std::cout<<"A maior sub cadeia reversa é: ";
    maiorSub->printCadeia();
    std::cout<<std::endl<<"Com o tamanho: "<<maiorSub->tamanho<<std::endl<<std::endl;
}
// Main pode receber argumentos com o caminho dos arquivos com cadeias e processalas ex ./questao4 CadeiaA.txt CadeiaB.txt
int main(int argc, char *argv[], char *envp[]){
    CadeiaPtr cadeiaA = nullptr;
    CadeiaPtr cadeiaB = nullptr;
    if(argc > 1) // Modo de execução 1
        ProcurarEmArquivos(argv,cadeiaA,cadeiaB);
    else // Modo de execução 2
        menu(cadeiaA,cadeiaB);
    return 0;
}