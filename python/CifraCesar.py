import os
clear = lambda: os.system('cls')
az = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","!","@","#","$","%","&","&","*","(",")","-","_","=","+","§","[","]","{","}","?",".",","]
op = 0
def crip(text,key):
    result = []
    if key > len(az):
        key = transkey(key)
    for i in range(len(text)):
        cod = findAZ(text[i]) + key
        if cod >= len(az):
            cod = cod - len(az)
        result.append(az[cod])
    return result
def decrip(text,key):
    result = []
    if key > len(az):
        key = transkey(key)
    for i in range(len(text)):
        cod = findAZ(text[i]) - key
        if cod < 0:
            cod = cod + len(az)
        result.append(az[cod])
    return result
def findAZ(letra):
    for i in range(len(az)):
        if letra == az[i]:
            return i
def printlist(lista):
    palavra = ""
    for i in range(len(lista)):
        palavra = palavra + str(lista[i])
    return palavra
def transkey(key):
    while(key > len(az)):
        key = key - len(az)
    return key
while(op != 1):
    clear()
    print("1 - sair")
    print("2  - crip")
    print("3  - decrip")
    op = int(input("Digite a op "))
    if op == 1:
        print("Saindo...")
        input()
    elif op == 2:
        text = input("Digite o texto letras de "+printlist(az).replace('',' ,')+" sem espaços:\n>")
        text = text.upper()
        key = int(input("Digite a chave entre 1 e "+ str(len(az))+":\n>"))
        print("",printlist(crip(text,key)))
        input("Pressione qualquer tecla para limpar a tela e voltar para o menu")
    elif op == 3:
        text = input("Digite o texto letras de "+printlist(az)+" sem espaços:\n>")
        text =  text.upper()
        key = int(input("Digite a chave entre 1 e "+ str(len(az))+":\n>"))
        print("",printlist(decrip(text,key)))
        input("Pressione qualquer tecla para limpar a tela e voltar para o menu")
    else:
        print("Op invalido")
        input("Pressione qualquer tecla para limpar a tela e voltar para o menu")