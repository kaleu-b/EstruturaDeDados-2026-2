# 6. Escreva uma discussão sobre os resultados obtidos, destacando os cenários de melhor caso, caso médio e pior caso para ambos os algoritmos.



# Suponha que você esteja procurando uma palavra em um dicionário. O dicionario tem 240000 palavras. Na pior das hipóteses, de quantas etapas você acha que a busca sequencial e busca binária precisaria? Consegue generalizar para qualquer entrada n?

Na pior das hipóteses, ou seja, a palavra ou não existe no dicionário ou é a última palavra do dicionário, a busca sequencial levaria 240000 etapas. 
Já a busca binária levaria entre 17 e 18 comparações nos piores casos, onde a palavra não existe ou é exatamente a última ou exatamente a primeira no dicionário, ou log base 2 de 240000.

A diferença no número de etapas necessárias se dá por conta de como os algoritmos funcionam:

A busca linear percorre cada elemento e compara cada um com o valor buscado.

Já a binária vai pulando vários elementos, e a cada pulo, "elimina" metade do array, até encontrar (ou não encontrar no pior caso) o elemento.

generalizando para qualquer entrada:
linear: O(n) (pode percorrer todos os elementos)
binaria: O(log n) (a cada etapa divide pela metade as possibilidades, fazendo com que ele percorra cerca de 17.87 elementos para qualquer busca nesse caso)