## Perguntas

1. A partir do seu diretório pessoal crie a seguinte estrutura de diretórios com somente um
comando: faeterj/lft/noite/revisao

2. Visualize as quatro primeiras linhas do arquivo /etc/services.

3. Mostre a última linha do arquivo /etc/passwd

4. Entre no diretório /faeterj/lft/noite/revisao. Use o comando cat para criar um arquivo
contendo 5 linhas chamado linhas.txt. As linha digitadas devem ser:
Um
dois
três
quatro
cinco

5. Use o comando cat para acrescentar novas linhas ao arquivo linhas.txt. As novas
linhas deverão ser inseridas no final do texto já existente no arquivo até que seja
digitado a palavra “finaliza” para encerrar a execução do comando.

6. Use o comando cp para fazer uma cópia do arquivo linhas.txt do exercício anterior
com o nome linhasCopia.txt. Mostre o conteúdo do arquivo linhasCopia.txt.

7. O comando echo imprime uma string na saída padrão do shell, ou seja imprime no
display a string digitada. No caso de uma digitação errada do comando echo (por
exemplo zecho) será retornado um erro na saída padrão que também é o display. Qual o
comando completo altera a saída padrão do erro para um arquivo com nome logerros.txt

8. Explique o que acontecerá e justifique o resultado, ao ser digitado o seguinte
comando: zecho vou inserir nova linha > linhasCopia.txt

9. Liste a partir do diretório atual todos os arquivos (inclusive ocultos) em detalhes do
diretório /etc exibindo-os de 25 em 25 linhas.

10. Crie uma forma para que o arquivo linhas.txt contenha as linhas originais digitadas na
questão 5 desta lista, seguidas pelo conteúdo de /etc/passwd que deverá ser seguido do
conteúdo original de linhas.txt (linhas originais digitadas na questão 5). Ou seja, ao final
o arquivo linhas.txt deverá conter:
Um
dois
três
quatro
cinco
…
“conteúdo /etc/passwd”
Um
dois
três
quatro
cinco
…

## Respostas:
1)
mkdir -p  faeterj/lft/noite/revisao

2)
head -n 4 /etc/services

3)
tail -1 /etc/passwd

4)

cd faeterj/lft/noite/revisao ; cat > linhas.txt
Um
dois
três
quatro
cinco

Ctrl-D

5)

6)
cp linhas.txt linhasCopia.txt ; cat linhasCopia.txt

7)
zecho &> logerros.txt


8)zecho vou inserir nova linha > linhasCopia.txt
Ira dar erro porque zecho não é nem um comando reconhecido pelo sistema irar, e o > irar sobre escrever o conteudo de linhasCopia.txt com nada, o arquivo ficara vazio.

9)
for((i=0;i < $(ls -a /etc | wc -l) ;i+=25)); do ls -ul /etc | head -n +$i | tail -25 ; read -p "Pressione [Enter] para imprimir os próximos 25..." ; done ; echo total: $(ls -a /etc | wc -l)

10)
