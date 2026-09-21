# Durante a execução, observe o comportamento da pilha.
# Explique, com suas palavras, o que acontece com a pilha quando o algoritmo:

# 1. encontra uma nova posição que pode ser explorada;
resposta aqui
# 2. chega a um caminho sem saída;
resposta aqui
# 3. precisa retornar a uma bifurcação;
resposta aqui
# 4. encontra o destino.
resposta aqui
  # Por fim, considerando um labirinto com L linhas e C colunas, determine a complexidade de tempo do 
  # algoritmo no pior caso e justifique sua resposta.

No pior caso, considerando que o labirinto tem L linhas e C colunas, e que tenha E espaços livres onde podemos navegar, levariámos O(E) por termos
que navegar todos os espaços pelo menos uma vez ou no máximo duas vezes (O(2*E), ou simplesmente O(E)). Se não tivéssemos as paredes, por exemplo, e o labirinto não tivesse saída, 
percorreríamos todas as linhas e todas as colunas e a complexidade seria O(L * C).