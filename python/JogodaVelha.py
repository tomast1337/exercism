import os     as system
import time 
import random as rand
clear = lambda: system.system('cls')
tempo = lambda x: time.sleep(x)
Board = [["","",""],["","",""],["","",""],]
player  = ""
maquina = ""
truno = ''
rodada = 0
def DrawVeticalLine(R = ['E','E','E']):
    for i in range(len(R)):
        if R[i] == '':
            R[i] = ' '
    print("  ",end='')
    print(R[0]      ,end='')
    print("  |  ",end='')
    print(R[1]      ,end='')
    print("  |  ",end='')
    print(R[2]     )
def DrawGameBoard(GameBoard = [['','',''],['','',''],['','','']]):
    print(' x0  | x1  | x2',     end='\n')
    DrawVeticalLine(GameBoard[0])
    print('y0   |     |',     end='\n')
    print('-----+-----+-----',end='\n')
    print('     |     |',     end='\n')
    DrawVeticalLine(GameBoard[1])
    print('y1   |     |',     end='\n')
    print('-----+-----+-----',end='\n')
    print('     |     |',     end='\n')
    DrawVeticalLine(GameBoard[2]) 
    print('y2   |     |',     end='\n')
def TesteJogada(cords = [0,0]):
    if Board[cords[0]][cords[1]] == ' ':
        return True
    else:
        return False
def TurnoJogador():
    global truno
    truno = 'computador'
    MovimentoLegal = False
    while MovimentoLegal == False:
        jogada = [4,4]
        while jogada[1] < 0 or jogada[1] > 2:
            jogada[1] = int(input("Digite a posição X\n>"))
        while jogada[0] < 0 or jogada[0] > 2:
            jogada[0] = int(input("Digite a posição Y\n>"))
        MovimentoLegal = TesteJogada(jogada)
    Board[jogada[0]][jogada[1]] = player
def TurnoComputador():
    global truno
    print("Fazendo jogada...")
    truno = 'player'
    MovimentoLegal = False
    while MovimentoLegal == False:
        jogada = [0,0]
        jogada[0] = rand.randint(0,2)
        jogada[1] = rand.randint(0,2)
        MovimentoLegal = TesteJogada(jogada)
    Board[jogada[0]][jogada[1]] = maquina
def TabuleiroCheio():
    esta = False
    for r in Board:
        for c in r:
            if c != '':
                esta == True
def ChecarVitoria(Jogador):
    Buscar = ''
    vitoria = False
    if Jogador == "computador":
        Buscar = maquina
    elif Jogador == "player":
        Buscar = player
    for i in range(3):
       if Board[0][i] == Buscar and Board[1][i] == Buscar and Board[2][i] == Buscar:
           vitoria = True
    for i in range(3):
        if Board[i][0] == Buscar and Board[i][1] == Buscar and Board[i][2] == Buscar:
            vitoria = True
    if Board[0][0] == Buscar and Board[1][1] == Buscar and Board[2][2] == Buscar:
        vitoria = True
    if Board[0][2] == Buscar and Board[1][1] == Buscar and Board[2][0] == Buscar:
        vitoria = True
    return vitoria
def Jogo(): 
    global player 
    global truno
    global rodada
    global maquina
    global Board
    Board = [["","",""],["","",""],["","",""],]
    player  = ""
    maquina = ""
    truno = ''
    rodada = 0
    ganhador = ""
    print(player)
    while player == '' or (player != 'X' and player != 'O'):
        player = input("Deseja Ser Xs ou Os\n>").upper()
    if player == 'X':
        truno = 'player'
        maquina = 'O'
    else:
        truno = 'computador'
        maquina = 'X'
    clear()    
    print("O",truno,"ira jogar primeiro")
    tempo(1)
    while ganhador == "":
        clear()
        print("X Jogo da Velha O")
        DrawGameBoard(Board)
        if truno == 'player':
            rodada = rodada + 1
            TurnoJogador()
            if rodada >= 5 and ChecarVitoria(truno):
                print("O",truno,"é o ganhador")
                break
        elif TabuleiroCheio():
            print("Deu velha")
            ganhador = "Velha"
            break
        else:
            rodada = rodada + 1
            TurnoComputador()
            if rodada >= 5 and ChecarVitoria(truno):
                print("O",truno,"é o ganhador")
                break
            tempo(2)
        tempo(2)  
def intro():
    clear()
    print("Por:Nicolas Vycas Nery")
    pass          
def main():
    intro()
    rodando = True
    while rodando:
        Jogo()
        resp = ''
        while resp != 'S' and resp != 'N':
            resp = input("Deseja sair do Jogo? (s ou n)").upper()
        if resp == 'S':
            print('Obrigado por jogar\nSaindo...')
            break 
main()