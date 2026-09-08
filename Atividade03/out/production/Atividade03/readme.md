# 1- Por que essa abordagem usando um array de instâncias da classe Vetor torna a busca de um contato mais rápida em comparação com a versão anterior (uma única lista contendo todos os contatos)?

Ele torna a busca mais rápida ao dividir a agenda, que seria anteriormente um monólito, em 26 seções para cada letra.

Assintoticamente falando, o custo é o mesmo, pois o algoritmo da busca binária é o mesmo (O(log n), n representando o n° de elementos).

O que essa abordagem faz na prática é possivelmente reduzir o escopo da busca.

Se considerarmos, por exemplo, uma lista com 10.000 contatos distrubuidos de forma mais ou menos uniforme entre os 26 vetores, cada vetor vai ter mais ou menos 385 contatos.
Aplicando a busca binária num vetor com 385 contatos, ou seja, log 385, temos 9 comparações feitas nos piores dos casos.
Na lista monolítica, essa busca levaria 14 etapas.

Representando em notação mais formal: O(log(n/26))* para a lista com seções e O(log n) para a monolítica, n representando o total de elementos.

Vale ressaltar que essa diminuição na quantidade de etapas pode parecer irrisória, mas em sistemas críticos pode ser significativo.

Considerando que a distribuição dos elementos é uniforme*

# 2 - O que acontece com o desempenho da busca se a maioria dos contatos cadastrados começar com a mesma letra (ex: centenas de nomes iniciando com a letra "M")? O sistema continuará rápido? Justifique.

Continua rápido, mas se tivermos muitos nomes de forma desproporcional na seção "M" da agenda, ele vai ter praticamento o mesmo custo da busca realizada no vetor monolítico.

Reusando o exemplo da lista com 10.000 contatos, mas considerando que 9.000 deles estão numa única seção e o resto está distribuido entre as outras seções,
temos: log 9.000 = 14. Que é o mesmo custo do vetor monolítico de 10.000 elementos.

Assintoticamente, continua igual, pois ainda é usado a busca binária. Na prática, a vantagem anterior de diminuir o espaço de busca é jogado pela janela.