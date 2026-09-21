# Durante a execução, observe o comportamento da pilha.
# Explique, com suas palavras, o que acontece com a pilha quando o algoritmo:

# 1. encontra uma nova posição que pode ser explorada;
a nova posição é adicionada á pilha.
# 2. chega a um caminho sem saída;
é feito pops/desempilhar até encontrar a última bifurcação.
# 3. precisa retornar a uma bifurcação;
é por que foi encontrado um caminho sem saída e foi necessário retornar á bifurcação.
# 4. encontra o destino.
é feito um break e é imprimido o caminho do inicio até o fim.
  # Por fim, considerando um labirinto com L linhas e C colunas, determine a complexidade de tempo do 
  # algoritmo no pior caso e justifique sua resposta.

No pior caso, considerando que o labirinto tem L linhas e C colunas, e que tenha E espaços livres onde podemos navegar, levariámos O(E) por termos
que navegar todos os espaços pelo menos uma vez ou no máximo duas vezes (O(2*E), ou simplesmente O(E)). Se não tivéssemos as paredes, por exemplo, e o labirinto não tivesse saída, 
percorreríamos todas as linhas e todas as colunas e a complexidade seria O(L * C).
