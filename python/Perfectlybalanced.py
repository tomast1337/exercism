#   Given a string containing only the characters x and y,
#   find whether there are the same number of xs and ys.
#                   Optional bonus
#   Given a string containing only lowercase letters,
#   find whether every letter that appears in the string appears the same number of times.
#   Don't forget to handle the empty string ("") correctly!
frase = input("Digite a String para ver se é balaceada\n")
frase = frase.lower()
frase = list(frase)
letras = {"0":0,    "a":0,  "j":0,  "s":0,
          "1":0,    "b":0,  "k":0,  "t":0,
          "2":0,    "c":0,  "l":0,  "u":0,
          "3":0,    "d":0,  "m":0,  "v":0,
          "4":0,    "e":0,  "n":0,  "w":0,
          "5":0,    "f":0,  "o":0,  "x":0,
          "6":0,    "g":0,  "p":0,  "y":0,
          "7":0,    "h":0,  "q":0,  "z":0,
          "8":0,    "i":0,  "r":0,  
          "9":0
         }
for LF in  frase:
    letras[LF] = letras[LF] + 1
final = {}
for l,q in letras.items():
    if q > 0:
        final[l] = q
        maxQ = final[l]
balanceada = True
for l,q in final.items():
    if q != maxQ:
        balanceada = False
if balanceada ==  True:
    print("".join(map(str, frase)),"Esta balanceada ✔")
else:
    print("".join(map(str, frase)),"Não esta balanceada ❌")
print(final)
