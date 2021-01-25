#                       Additive Persistence
#Description
#Inspired by this tweet, -> https://twitter.com/fermatslibrary/status/1089883307473543170
#today's challenge is to calculate the additive persistence of a number, -> http://mathworld.wolfram.com/AdditivePersistence.html
#defined as how many loops you have to do summing its digits until you get a single digit number.
# 
#-Take an integer N:
#
#-Add its digits
#
#-Repeat until the result has 1 digit
#
#-The total number of iterations is the additive persistence of N.
#
#Your challenge today is to implement a function that calculates the additive persistence of a number.
def AdditivePersistence(numeros):
    numeros = str(numeros)
    numeros.split()
    total = 0
    voltas = 0
    while int(numeros) < 0 or int(numeros) > 9: 
        for n in numeros:
            total = int(n) + total
        voltas = voltas + 1
        print(total)
        numeros = str(total)
        numeros.split()
        total = 0
    return numeros,voltas

x = input("Digite um numero\n->")
t ,v = AdditivePersistence(x)
print("\nResultado",t)
print("\n",x,"->",v)