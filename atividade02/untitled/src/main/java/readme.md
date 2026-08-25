# 6. Escreva uma discussão sobre os resultados obtidos, destacando os cenários de melhor caso, caso médio e pior caso para ambos os algoritmos.

O melhor caso para os algoritmos de busca linear é onde o elemento buscado é o primeiro elemento (leva 1 comparação em todos os casos com todos os vetores)

O caso intermediário é onde o elemento buscado está no meio (levando n/2, ou 500 comparações para o vetor de mil, 5000 para o de 10 mil, 50000 para o de cem mil)

O pior caso é onde o elemento buscado está nas últimas posições (levando 1000 comparações para o vetor de mil, 10000 para o de 10 mil e 100000 para o de cem mil)

Para a busca binária o melhor caso é onde o elemento buscado está no meio do vetor, levando 1 comparação em todos os casos.

Para os piores casos, sendo eles 2: quando o alvo é o primeiro ou o último elemento. 
levando log n de comparações (ou aproximadamente 10 comparações para o vetor de mil, 13 para o de dez mil e 16 para o de cem mil)

Apesar da medida de tempo não ser consistente em todos os casos para todos os vetores, a diferença de tempo entre os algoritmos é significativa.
Com a busca binária levando menos de 1 ms em todos os casos, e a linear podendo levar mais de 10ms ou mais em certos casos.

# Suponha que você esteja procurando uma palavra em um dicionário. O dicionario tem 240000 palavras. Na pior das hipóteses, de quantas etapas você acha que a busca sequencial e busca binária precisaria? Consegue generalizar para qualquer entrada n?

Na pior das hipóteses, ou seja, a palavra ou não existe no dicionário ou é a última palavra do dicionário, a busca sequencial levaria 240000 etapas.
Já a busca binária levaria entre 17 e 18 comparações nos piores casos, onde a palavra não existe ou é exatamente a última ou exatamente a primeira no dicionário, ou log base 2 de 240000.

A diferença no número de etapas necessárias se dá por conta de como os algoritmos funcionam:

A busca linear percorre cada elemento e compara cada um com o valor buscado.

Já a binária vai pulando vários elementos, e a cada pulo, "elimina" metade do array, até encontrar (ou não encontrar no pior caso) o elemento.

generalizando para qualquer entrada:
linear: O(n) (pode percorrer todos os elementos)
binaria: O(log n) (a cada etapa divide pela metade as possibilidades, fazendo com que ele percorra cerca de 17.87 elementos para qualquer busca nesse caso)

# Avalie se há diferença significativa de tempo entre a implementação própria e a versão otimizada da biblioteca Java.

A única diferença significativa de tempo foi na primeira busca feita, onde demora significantemente mais. Mas nas buscas seguinte, não tem diferenças significativas.