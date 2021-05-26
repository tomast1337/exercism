# Esse script Gera os arquivos das cadeias e compila e  executa o programa questao4 no modo execução 1
# Fiz ele para realizar teste mais automatizados, e com cadeia maiores
import random
import os
# Gera string que define a cadeia
def cadeia(tamanho):
    cadeia = ""
    for _ in range(tamanho):
        escolha = random.randint(0, 4)
        if escolha == 1:
            cadeia += "A"
        elif escolha == 2:
            cadeia += "C"
        elif  escolha == 3:
            cadeia += "G"
        else: 
            cadeia += "T"
    return cadeia

#Escreve aquivo da cadeia
def escreverArquivo(nome,tamanho):
    with open(nome,"w") as file:
        file.flush()
        file.write(cadeia(tamanho))

escreverArquivo("CadeiaA.txt",239)
escreverArquivo("CadeiaB.txt",189)
print("Executando: g++ -g questao4.cpp -o questao4")
os.system("g++ -g questao4.cpp -o questao4")
print("Executando: ./questao4 CadeiaA.txt CadeiaB.txt")
os.system('./questao4 CadeiaA.txt CadeiaB.txt')