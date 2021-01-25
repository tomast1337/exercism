#Desenha moldura. Construa uma função que desenhe um retângulo usando os caracteres
#`+' , `−' e `|'. Esta função deve receber dois parâmetros, linhas e colunas, sendo que o valor
#por omissão é o valor mínimo igual a 1 e o valor máximo é 20. Se valores fora da faixa forem
#informados, eles devem ser modicados para valores dentro da faixa de forma elegante.
# Retirado de: http://www.dainf.ct.utfpr.edu.br/petcoce/wp-content/uploads/2013/09/document.pdf
def drawX(i):
    print('+'+'-'*(i-2)+'+')
def drawY(i,j):
    print(i*("|"+(" "*int(int(j)-2))+"|"+"\n"),end='')
def drawFrame(x,y):
    if x <= 20 or y <= 20:
        drawX(x)
        drawY(y,x)
        drawX(x)
    else:
         print("Tamanho invalido")
s = 'n'
while(s != 'S' or s != 's'):
    x = int(input("Tamanho x\n>>>"))
    y = int(input("Tamanho y\n>>>"))
    drawFrame(x,y)
    s = input("Deseja sair (s ou n)")
    if s == 'S' or s == 'S':
        print("Saindo...")