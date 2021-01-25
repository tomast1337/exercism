#                       O jogo "adivinhe o número"
#Através do que já vimos, vamos fazer um jogo de adivinhação de números. Neste jogo, o
#computador sorteará um número entre 1 e 20 e pedirá ao usuário para adivinhar este número. Você
#terá 6 chances e o computador o informará se seu palpite é maior ou menor que o número sorteado.
#Se você adivinhá-lo dentro de 6 tentativas, você vence.
#Este é um bom programa de início, pois utiliza números (pseudo) aleatórios, loops e entrada do
#usuário em um código curto. Assim que você escrever o programa, você aprenderá a converter valores
#para diferentes tipos de dados (e o porquê de necessitar este artifício).
#Devido a estarmos lidando com jogos, eventualmente chamaremos o usuário de jogador, mas
#chamá-lo de usuário também é adequado

#Fonte http://www.dainf.ct.utfpr.edu.br/petcoce/wp-content/uploads/2013/09/document.pdf
import random

tentativas = 0
nome = input("\nQual é o seu nome?>>>")
resp = int(random.randint(1,20))
perdeu = True
while tentativas < 6:
    quess = int(input("Tenhte adivinhar.>>>"))
    tentativas = tentativas + 1
    if quess == resp:
        print("\nVoce acertou!")
        input("\nFim de jogo, "+nome+" Voce acertou o numero em "+str(tentativas)+" tentativas!")
        perdeu = False
        break;
    elif quess > resp:
        print("\nValor muito alto!")
        perdeu = True
    elif quess < resp:
        print("\nValor muito baixo!")
        perdeu = True
if(perdeu == True):
    input("\nFim de jogo, "+nome+" Voce Perdeu! o numero correto era "+str(resp))