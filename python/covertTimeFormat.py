#Faça um programa que converta da notação de 24 horas para a notação de 12 horas. Por
#exemplo, o programa deve converter 14:25 em 2:25 P.M. A entrada é dada em dois inteiros.
#Deve haver pelo menos duas funções: uma para fazer a conversão e uma para a saída. Registre
#a informação A.M./P.M. como um valor `A' para A.M. e `P' para P.M. Assim, a função para
#efetuar as conversões terá um parâmetro formal para registrar se é A.M.
# Retirado de: http://www.dainf.ct.utfpr.edu.br/petcoce/wp-content/uploads/2013/09/document.pdf
def AmPm(horas = "0000"):
    extra = 0
    minuto = int(horas % 100)
    if minuto > 59:
        extra  = int(minuto/60)
        minuto = int(minuto%60)
    hora   = int(horas / 100) + extra
    if(hora > 12):
        hora = hora - 12
        if minuto == 0:
            return str(hora)+":00 PM"
        else:   
            return str(hora)+":"+str(minuto)+" PM"
print(AmPm(1425))
        
