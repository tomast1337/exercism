import random as rand
import os
wordList  = [
             'banana',
             'morango',
             'abacate',
             'abacaxi',
             'acerola',
             'amora',
             'caqui',
             'carambola',
             'cereja',
             'coco',
             'framboesa',
             'goiaba',
             'groselha',
             'kiwi',
             'laranja',
             'limao',
             'mamao',
             'manga',
             'maracuja',
             'melancia',
             'Morango',
             'pera',
             'pessego',
             'tangerina',
             'Uva',
             'tomate',
             'abobora',
             'chuchu',
             'pimentão',
             'pepino',
             'abobrinha',
             'quiabo'
             ]
etagios = [
'''
    +---+
    |   |
        |
        |
        |
        |
=========
''',
'''
    +---+
    |   |
    O   |
        |
        |
        |
=========
''',
'''
    +---+
    |   |
    O   |
    |   |
        |
        |
=========
''',
'''
    +---+
    |   |
    O   |
   /|   |
        |
        |
=========
''',
'''
    +---+
    |   |
    O   |
   /|\  |
        |
        |
=========
''',
'''
    +---+
    |   |
    O   |
   /|\  |
   /    |
        |
=========
''',
'''
    +---+
    |   |
    O   |
   /|\  |
   / \  |
        |
=========
''',
'''
    +---+
    |   |
Mor X   |
to /|\  |
   / \  |
        |
=========
''']
clear = lambda: os.system('cls')
PDic = {}
vida = 0
acerto = 0
letras = []
def geraPalavraDic():
    palavra = {}#(0,len(wordList))
    p = wordList[rand.randint(0,len(wordList)-1)]
    i  = 0
    for l in p:
        palavra.update({i:(l,False)})
        i = i + 1
    return palavra
def drawPalavra(PalavraDic):
    p = ''
    for index , estado in PalavraDic.items(): 
        if estado[1] == True:
            p += estado[0] + " "
        else:
            p += '_ '
    return p
def drawLetras(letras):
    final = 'Letras usadas:'
    for l in letras:
        final = final + " " + l
    return final
def testarResp(l):
    global PDic
    erro = True
    letras.append(l)
    clear()
    for index , estado in PDic.items():
        if l ==  estado[0]:
            PDic.update({index:[estado[0],True]})
            print('Tentativa\"',l,'\"CORRETA')
            erro = False
            global acerto
            acerto = acerto + 1
    if erro == True:
        print('Tentativa\"'+l+'\"ERRADA')
        global vida
        vida = vida + 1
def draw(v,dic,l):
    print(etagios[v])
    print(drawPalavra(dic))
    print(drawLetras(l))
def main():
    while(True):
        clear()
        global PDic
        global vida
        global acerto
        global letras
        PDic = geraPalavraDic()
        vida = 0
        acerto = 0
        letras = []
        while(True):
            draw(vida,PDic,letras)
            resp = ""
            while resp == "" :
                resp = input("Adivinhe uma letra\n>")
            testarResp(resp)
            if vida == len(etagios):
                clear()
                print('Perdeu \n')
                break;
            if acerto == len(PDic):
                clear()
                print('Ganhou \n')
                break;
        sair = ""
        while sair == "" or sair != "s" or sair != "n":
            sair = input("Deseja jogar novamente (S ou N)?").lower()
        if sair == 'n':
            print("saindo...")
            break; 
main()
        
        