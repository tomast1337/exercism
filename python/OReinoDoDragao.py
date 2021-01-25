#                   O Reino do Dragão
# Neste jogo, o jogador está em uma terra cheia de dragões. Os dragões vivem em cavernas com
# grandes quantidades de tesouros. Alguns dragões são amigáveis e compartilharão o tesouro com o
# jogador. Outros são gananciosos e famintos, e devorarão qualquer um que entrar em sua caverna. O
# jogador está em frente a duas cavernas, uma com um dragão amigável e outra com um ganancioso.
# Ele pode escolher entre uma das cavernas.
# Retirado de: http://www.dainf.ct.utfpr.edu.br/petcoce/wp-content/uploads/2013/09/document.pdf
import random
import time
nivelSupense = 2
def introducao():
    print("Voce esta em um terra cheia de dragoes,")
    time.sleep(nivelSupense/2)
    print("Voce duas carvernas,")
    time.sleep(nivelSupense/2)
    print("Em uma a gum dragão amigavel que ira dividir seus tesouros,")
    time.sleep(nivelSupense/2)
    print("E em outra a um dragão que ira devoralo imediatamnte,")
def entrarCaverna():
    time.sleep(nivelSupense)
    print("Voce entra na caverna ,...")
    time.sleep(nivelSupense)
    print("... é escura e assustadora ,...")
    time.sleep(nivelSupense)
    print("... Um dradão gigante abre sua madibula e ...")
    time.sleep(nivelSupense)
def cavernas():
    caverna = random.randint(1, 2)
    time.sleep(nivelSupense)
    resp = ''
    while resp != '1' and resp != '2':
        resp = input("Em qual das duas carvernas voce entra (1 ou 2)?\n>>>")
    if str(caverna) == resp:
        entrarCaverna()
        time.sleep(nivelSupense)
        print("Te da todos os tessourous e voce se torna muito rico")
    else:
        entrarCaverna()
        time.sleep(nivelSupense)
        print("Engole voce interio com uma mordida!")
def jogo():
    while(True):
        introducao()
        cavernas()
        print("Fim de jogo...")
        time.sleep(nivelSupense/2)
        x = ''
        while x != 'S' and x != 'N':
            x = input("Voce quer jogar novamente? (S ou N)\n>>>").isupper()
            print(x)
        if x == 'N':
            print("Saindo..") 
            break;
jogo()
